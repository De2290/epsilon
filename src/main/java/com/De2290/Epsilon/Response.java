package com.De2290.Epsilon;

public class Response {
    private String body;
    private String status;
    private String headers;

    public Response(String body, String status, String headers) {
        this.body = body;
        this.status = status;
        this.headers = headers;
    }

    public Response(String body, String status) {
        this.body = body;
        this.status = status;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Response(String body) {
        this.body = body;
    }

}
