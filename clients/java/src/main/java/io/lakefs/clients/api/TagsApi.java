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

import io.lakefs.clients.api.ApiCallback;
import io.lakefs.clients.api.ApiClient;
import io.lakefs.clients.api.ApiException;
import io.lakefs.clients.api.ApiResponse;
import io.lakefs.clients.api.Configuration;
import io.lakefs.clients.api.Pair;
import io.lakefs.clients.api.ProgressRequestBody;
import io.lakefs.clients.api.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import io.lakefs.clients.api.model.Error;
import io.lakefs.clients.api.model.Ref;
import io.lakefs.clients.api.model.RefList;
import io.lakefs.clients.api.model.TagCreation;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TagsApi {
    private ApiClient localVarApiClient;

    public TagsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public TagsApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for createTag
     * @param repository  (required)
     * @param tagCreation  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> tag </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Validation Error </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Resource Not Found </td><td>  -  </td></tr>
        <tr><td> 409 </td><td> Resource Conflicts With Target </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createTagCall(String repository, TagCreation tagCreation, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = tagCreation;

        // create path and map variables
        String localVarPath = "/repositories/{repository}/tags"
            .replaceAll("\\{" + "repository" + "\\}", localVarApiClient.escapeString(repository.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "basic_auth", "cookie_auth", "jwt_token", "oidc_auth" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call createTagValidateBeforeCall(String repository, TagCreation tagCreation, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'repository' is set
        if (repository == null) {
            throw new ApiException("Missing the required parameter 'repository' when calling createTag(Async)");
        }
        
        // verify the required parameter 'tagCreation' is set
        if (tagCreation == null) {
            throw new ApiException("Missing the required parameter 'tagCreation' when calling createTag(Async)");
        }
        

        okhttp3.Call localVarCall = createTagCall(repository, tagCreation, _callback);
        return localVarCall;

    }

    /**
     * create tag
     * 
     * @param repository  (required)
     * @param tagCreation  (required)
     * @return Ref
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> tag </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Validation Error </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Resource Not Found </td><td>  -  </td></tr>
        <tr><td> 409 </td><td> Resource Conflicts With Target </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public Ref createTag(String repository, TagCreation tagCreation) throws ApiException {
        ApiResponse<Ref> localVarResp = createTagWithHttpInfo(repository, tagCreation);
        return localVarResp.getData();
    }

    /**
     * create tag
     * 
     * @param repository  (required)
     * @param tagCreation  (required)
     * @return ApiResponse&lt;Ref&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> tag </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Validation Error </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Resource Not Found </td><td>  -  </td></tr>
        <tr><td> 409 </td><td> Resource Conflicts With Target </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Ref> createTagWithHttpInfo(String repository, TagCreation tagCreation) throws ApiException {
        okhttp3.Call localVarCall = createTagValidateBeforeCall(repository, tagCreation, null);
        Type localVarReturnType = new TypeToken<Ref>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * create tag (asynchronously)
     * 
     * @param repository  (required)
     * @param tagCreation  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> tag </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Validation Error </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Resource Not Found </td><td>  -  </td></tr>
        <tr><td> 409 </td><td> Resource Conflicts With Target </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createTagAsync(String repository, TagCreation tagCreation, final ApiCallback<Ref> _callback) throws ApiException {

        okhttp3.Call localVarCall = createTagValidateBeforeCall(repository, tagCreation, _callback);
        Type localVarReturnType = new TypeToken<Ref>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for deleteTag
     * @param repository  (required)
     * @param tag  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> tag deleted successfully </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Resource Not Found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteTagCall(String repository, String tag, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/repositories/{repository}/tags/{tag}"
            .replaceAll("\\{" + "repository" + "\\}", localVarApiClient.escapeString(repository.toString()))
            .replaceAll("\\{" + "tag" + "\\}", localVarApiClient.escapeString(tag.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "basic_auth", "cookie_auth", "jwt_token", "oidc_auth" };
        return localVarApiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call deleteTagValidateBeforeCall(String repository, String tag, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'repository' is set
        if (repository == null) {
            throw new ApiException("Missing the required parameter 'repository' when calling deleteTag(Async)");
        }
        
        // verify the required parameter 'tag' is set
        if (tag == null) {
            throw new ApiException("Missing the required parameter 'tag' when calling deleteTag(Async)");
        }
        

        okhttp3.Call localVarCall = deleteTagCall(repository, tag, _callback);
        return localVarCall;

    }

    /**
     * delete tag
     * 
     * @param repository  (required)
     * @param tag  (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> tag deleted successfully </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Resource Not Found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public void deleteTag(String repository, String tag) throws ApiException {
        deleteTagWithHttpInfo(repository, tag);
    }

    /**
     * delete tag
     * 
     * @param repository  (required)
     * @param tag  (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> tag deleted successfully </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Resource Not Found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Void> deleteTagWithHttpInfo(String repository, String tag) throws ApiException {
        okhttp3.Call localVarCall = deleteTagValidateBeforeCall(repository, tag, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * delete tag (asynchronously)
     * 
     * @param repository  (required)
     * @param tag  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> tag deleted successfully </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Resource Not Found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteTagAsync(String repository, String tag, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = deleteTagValidateBeforeCall(repository, tag, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
    /**
     * Build call for getTag
     * @param repository  (required)
     * @param tag  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> tag </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Resource Not Found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getTagCall(String repository, String tag, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/repositories/{repository}/tags/{tag}"
            .replaceAll("\\{" + "repository" + "\\}", localVarApiClient.escapeString(repository.toString()))
            .replaceAll("\\{" + "tag" + "\\}", localVarApiClient.escapeString(tag.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "basic_auth", "cookie_auth", "jwt_token", "oidc_auth" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getTagValidateBeforeCall(String repository, String tag, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'repository' is set
        if (repository == null) {
            throw new ApiException("Missing the required parameter 'repository' when calling getTag(Async)");
        }
        
        // verify the required parameter 'tag' is set
        if (tag == null) {
            throw new ApiException("Missing the required parameter 'tag' when calling getTag(Async)");
        }
        

        okhttp3.Call localVarCall = getTagCall(repository, tag, _callback);
        return localVarCall;

    }

    /**
     * get tag
     * 
     * @param repository  (required)
     * @param tag  (required)
     * @return Ref
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> tag </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Resource Not Found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public Ref getTag(String repository, String tag) throws ApiException {
        ApiResponse<Ref> localVarResp = getTagWithHttpInfo(repository, tag);
        return localVarResp.getData();
    }

    /**
     * get tag
     * 
     * @param repository  (required)
     * @param tag  (required)
     * @return ApiResponse&lt;Ref&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> tag </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Resource Not Found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Ref> getTagWithHttpInfo(String repository, String tag) throws ApiException {
        okhttp3.Call localVarCall = getTagValidateBeforeCall(repository, tag, null);
        Type localVarReturnType = new TypeToken<Ref>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * get tag (asynchronously)
     * 
     * @param repository  (required)
     * @param tag  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> tag </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Resource Not Found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getTagAsync(String repository, String tag, final ApiCallback<Ref> _callback) throws ApiException {

        okhttp3.Call localVarCall = getTagValidateBeforeCall(repository, tag, _callback);
        Type localVarReturnType = new TypeToken<Ref>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for listTags
     * @param repository  (required)
     * @param prefix return items prefixed with this value (optional)
     * @param after return items after this value (optional)
     * @param amount how many items to return (optional, default to 100)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> tag list </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Resource Not Found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listTagsCall(String repository, String prefix, String after, Integer amount, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/repositories/{repository}/tags"
            .replaceAll("\\{" + "repository" + "\\}", localVarApiClient.escapeString(repository.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (prefix != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("prefix", prefix));
        }

        if (after != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("after", after));
        }

        if (amount != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("amount", amount));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "basic_auth", "cookie_auth", "jwt_token", "oidc_auth" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listTagsValidateBeforeCall(String repository, String prefix, String after, Integer amount, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'repository' is set
        if (repository == null) {
            throw new ApiException("Missing the required parameter 'repository' when calling listTags(Async)");
        }
        

        okhttp3.Call localVarCall = listTagsCall(repository, prefix, after, amount, _callback);
        return localVarCall;

    }

    /**
     * list tags
     * 
     * @param repository  (required)
     * @param prefix return items prefixed with this value (optional)
     * @param after return items after this value (optional)
     * @param amount how many items to return (optional, default to 100)
     * @return RefList
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> tag list </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Resource Not Found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public RefList listTags(String repository, String prefix, String after, Integer amount) throws ApiException {
        ApiResponse<RefList> localVarResp = listTagsWithHttpInfo(repository, prefix, after, amount);
        return localVarResp.getData();
    }

    /**
     * list tags
     * 
     * @param repository  (required)
     * @param prefix return items prefixed with this value (optional)
     * @param after return items after this value (optional)
     * @param amount how many items to return (optional, default to 100)
     * @return ApiResponse&lt;RefList&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> tag list </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Resource Not Found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<RefList> listTagsWithHttpInfo(String repository, String prefix, String after, Integer amount) throws ApiException {
        okhttp3.Call localVarCall = listTagsValidateBeforeCall(repository, prefix, after, amount, null);
        Type localVarReturnType = new TypeToken<RefList>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * list tags (asynchronously)
     * 
     * @param repository  (required)
     * @param prefix return items prefixed with this value (optional)
     * @param after return items after this value (optional)
     * @param amount how many items to return (optional, default to 100)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> tag list </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Resource Not Found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listTagsAsync(String repository, String prefix, String after, Integer amount, final ApiCallback<RefList> _callback) throws ApiException {

        okhttp3.Call localVarCall = listTagsValidateBeforeCall(repository, prefix, after, amount, _callback);
        Type localVarReturnType = new TypeToken<RefList>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
