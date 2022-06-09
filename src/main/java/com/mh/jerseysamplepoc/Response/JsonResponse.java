package com.mh.jerseysamplepoc.Response;

public class JsonResponse {

    private JsonResponseResult status;
    private String message;

    public JsonResponse(JsonResponseResult status, String message) {
        this.status = status;
        this.message = message;
    }

    public JsonResponseResult getStatus() {
        return status;
    }

    public void setStatus(JsonResponseResult status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
