package committed

import (
	"encoding/binary"
	"errors"
	"fmt"

	"github.com/treeverse/lakefs/pkg/graveler"
)

// ErrBadValueBytes is an error that is probably returned when unmarshalling bytes that are
// supposed to encode a Value.
var ErrBadValueBytes = errors.New("bad bytes format for graveler.Value")

// ErrTooLong is an error that is returned when trying to marshal too long a key or value.
// This should never normally happen in graveler files generated by graveler.
var ErrTooLong = errors.New("too long")

// MaxValueComponentBytes is the longest size allowed for the data length of a graveler value
// (or its identity, but that is controlled by code here, so less likely).  It (only) protects
// the process from unbounded serialization.  "640 KB should be enough for anyone" - even at a
// few 10s of KiBs you may be better served with some other format or implementation.
const MaxValueComponentBytes = 640 << 16

/*
 * Value is serialized in a trivial fixed-order format:
 *
 *    | len(Identity) | Identity | len(Value) | Value |
 *
 * where each length is serialized as a varint and additional bytes after Value are silently
 * ignored.
 */

func varintBytes(i int) []byte {
	e := make([]byte, binary.MaxVarintLen64)
	l := binary.PutVarint(e, int64(i))
	return e[:l]
}

func putBytes(buf *[]byte, b []byte) {
	*buf = append(*buf, varintBytes(len(b))...)
	*buf = append(*buf, b...)
}

// MarshalValue returns bytes that uniquely unmarshal into a Value equal to v.
func MarshalValue(v *graveler.Value) ([]byte, error) {
	if len(v.Identity) > MaxValueComponentBytes || len(v.Data) > MaxValueComponentBytes {
		return nil, ErrTooLong
	}
	ret := make([]byte, 0, len(v.Identity)+len(v.Data)+2*binary.MaxVarintLen32)
	putBytes(&ret, v.Identity)
	putBytes(&ret, v.Data)
	return ret, nil
}

// MustMarshalValue an MarshalValue that will panic on error
func MustMarshalValue(v *graveler.Value) []byte {
	val, err := MarshalValue(v)
	if err != nil {
		panic(err)
	}
	return val
}

func getBytes(b *[]byte) ([]byte, error) {
	l, o := binary.Varint(*b)
	if o < 0 {
		return nil, fmt.Errorf("read length: %w", ErrBadValueBytes)
	}
	*b = (*b)[o:]
	if len(*b) < int(l) {
		return nil, fmt.Errorf("not enough bytes to read %d bytes: %w", l, ErrBadValueBytes)
	}
	if l < 0 {
		return nil, fmt.Errorf("impossible negative length %d: %w", l, ErrBadValueBytes)
	}
	ret := make([]byte, l)
	copy(ret, (*b)[:l])
	*b = (*b)[l:]
	return ret, nil
}

func UnmarshalValue(b []byte) (*graveler.Value, error) {
	ret := &graveler.Value{}
	var err error
	if ret.Identity, err = getBytes(&b); err != nil {
		return nil, fmt.Errorf("identity field: %w", err)
	}
	if ret.Data, err = getBytes(&b); err != nil {
		return nil, fmt.Errorf("data field: %w", err)
	}
	return ret, nil
}

// UnmarshalIdentity returns *only* the Identity field encoded by b.  It does not even examine
// any bytes beyond the prefix of b holding Identity.
func UnmarshalIdentity(b []byte) ([]byte, error) {
	return getBytes(&b)
}
