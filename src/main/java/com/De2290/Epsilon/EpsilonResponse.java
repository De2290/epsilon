package com.De2290.Epsilon;

public class EpsilonResponse {
    private String body;
    private String status;
    private String headers;

    /**
     *
     * @param body
     * @param status
     * @param headers
     */
    public EpsilonResponse(String body, String status, String headers) {
        this.body = body;
        this.status = status;
        this.headers = headers;
    }

    /**
     *
     * @param body
     * @param status
     */
    public EpsilonResponse(String body, String status) {
        this.body = body;
        this.status = status;
    }

    /**
     *
     * @return
     */
    public String getHeaders() {
        return headers;
    }

    /**
     *
     * @param headers
     */
    public void setHeaders(String headers) {
        this.headers = headers;
    }

    /**
     *
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     */
    public String getBody() {
        return body;
    }

    /**
     *
     * @param body
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     *
     * @param body
     */
    public EpsilonResponse(String body) {
        this.body = body;
    }

}
