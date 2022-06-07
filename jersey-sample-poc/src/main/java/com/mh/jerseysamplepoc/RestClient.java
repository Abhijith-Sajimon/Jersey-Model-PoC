package com.mh.jerseysamplepoc;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RestClient {
    private Client apiClient;
    private WebTarget webTarget;
    private Response response;
    public static final String TYPE = "type";
    public static final String JSON_RESPONSE = "json";
    public static final String PROPERTIES_FILE = "app.properties";
    public static Properties properties = new Properties();

    private Properties readProperties() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE);
        if (inputStream != null) {
            try {
                properties.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }

    public RestClient() {
        this.apiClient = ClientBuilder.newClient();
    }

    public String getUserData() {
        readProperties();
        String requestURI = properties.getProperty("request.user.uri");
        WebTarget webTarget = getWebTarget(requestURI);
        try {
            response = webTarget.request(MediaType.APPLICATION_JSON).get();
            String jsonString = response.readEntity(String.class);
            return jsonString;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public String getPostsData() {
        readProperties();
        String requestURI = properties.getProperty("request.post.uri");
        WebTarget webTarget = getWebTarget(requestURI);
        try {
            response = webTarget.request(MediaType.APPLICATION_JSON).get();
            String jsonString = response.readEntity(String.class);
            return jsonString;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public String getCommentsData() {
        readProperties();
        String requestURI = properties.getProperty("request.comments.uri");
        WebTarget webTarget = getWebTarget(requestURI);
        try {
            response = webTarget.request(MediaType.APPLICATION_JSON).get();
            String jsonString = response.readEntity(String.class);
            return jsonString;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private WebTarget getWebTarget(String requestURI) {
        webTarget = this.apiClient.target(requestURI);
        webTarget = webTarget.queryParam(TYPE, JSON_RESPONSE);
        return webTarget;
    }
}
