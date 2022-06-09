package com.mh.jerseysamplepoc;

import com.mh.jerseysamplepoc.Response.JsonResponse;
import com.mh.jerseysamplepoc.Response.JsonResponseResult;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JerseyRestClient {
    private Client apiClient;
    private JsonResponse jsonResponse;
    private String requestURI;
    public static final String TYPE = "type";
    public static final String JSON_RESPONSE = "json";
    public static final String PROPERTIES_FILE = "app.properties";

    public static final String USERS_RESOURCE = "request.users.uri";

    public static final String POSTS_RESOURCE = "request.posts.uri";

    public static final String COMMENTS_RESOURCE = "request.comments.uri";

    public static final String EMPTY_RESPONSE_BODY = "Empty Response Body";
    public static Properties properties = new Properties();

    private void readProperties() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE);
        if (inputStream != null) {
            try {
                properties.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public JerseyRestClient() {
        this.apiClient = ClientBuilder.newClient();
        readProperties();
    }

    private WebTarget getWebTarget(String requestURI) {

        WebTarget webTarget = this.apiClient.target(requestURI);
        webTarget = webTarget.queryParam(TYPE, JSON_RESPONSE);
        return webTarget;
    }

    public JsonResponse getUserData() {

        requestURI = properties.getProperty(USERS_RESOURCE);
        try {
            Response response = getWebTarget(requestURI).request(MediaType.APPLICATION_JSON).get();
            jsonResponse = getJsonResponse(response);
        } catch (Exception e) {
            jsonResponse = new JsonResponse(JsonResponseResult.ERROR, e.getMessage());
        }
        return jsonResponse;
    }

    public JsonResponse getPostsData() {

        requestURI = properties.getProperty(POSTS_RESOURCE);
        try {
            Response response = getWebTarget(requestURI).request(MediaType.APPLICATION_JSON).get();
            jsonResponse = getJsonResponse(response);
        } catch (Exception e) {
            jsonResponse = new JsonResponse(JsonResponseResult.ERROR, e.getMessage());
        }
        return jsonResponse;
    }

    public JsonResponse getCommentsData() {

        requestURI = properties.getProperty(COMMENTS_RESOURCE);
        try {
            Response response = getWebTarget(requestURI).request(MediaType.APPLICATION_JSON).get();
            jsonResponse = getJsonResponse(response);
        } catch (Exception e) {
            jsonResponse = new JsonResponse(JsonResponseResult.ERROR, e.getMessage());
        }
        return jsonResponse;
    }

    protected JsonResponse getJsonResponse(Response response) {

        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            return new JsonResponse(JsonResponseResult.ERROR, response.getStatusInfo().getReasonPhrase());
        }

        if (!response.hasEntity()) {
            return new JsonResponse(JsonResponseResult.ERROR, EMPTY_RESPONSE_BODY );
        }

        String jsonResponseString = response.readEntity(String.class);

        return new JsonResponse(JsonResponseResult.SUCCESS, jsonResponseString);
    }
}
