/*
 * lakeFS API
 * lakeFS HTTP API
 *
 * The version of the OpenAPI document: 0.1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package io.lakefs.clients.api;

import io.lakefs.clients.api.ApiException;
import io.lakefs.clients.api.model.Error;
import io.lakefs.clients.api.model.ObjectStats;
import io.lakefs.clients.api.model.StagingLocation;
import io.lakefs.clients.api.model.StagingMetadata;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for StagingApi
 */
@Ignore
public class StagingApiTest {

    private final StagingApi api = new StagingApi();

    
    /**
     * get a physical address and a return token to write object to underlying storage
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getPhysicalAddressTest() throws ApiException {
        String repository = null;
        String branch = null;
        String path = null;
                StagingLocation response = api.getPhysicalAddress(repository, branch, path);
        // TODO: test validations
    }
    
    /**
     * associate staging on this physical address with a path
     *
     * If the supplied token matches the current staging token, associate the object as the physical address with the supplied path.  Otherwise, if staging has been committed and the token has expired, return a conflict and hint where to place the object to try again.  Caller should copy the object to the new physical address and PUT again with the new staging token.  (No need to back off, this is due to losing the race against a concurrent commit operation.) 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void linkPhysicalAddressTest() throws ApiException {
        String repository = null;
        String branch = null;
        String path = null;
        StagingMetadata stagingMetadata = null;
                ObjectStats response = api.linkPhysicalAddress(repository, branch, path, stagingMetadata);
        // TODO: test validations
    }
    
}