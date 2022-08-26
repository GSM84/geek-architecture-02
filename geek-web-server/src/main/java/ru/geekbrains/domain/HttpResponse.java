package ru.geekbrains.domain;

import java.util.HashMap;
import java.util.Map;

public class HttpResponse {

    private int statusCode;

    private String protocol;

    private Map<String, String> headers;

    private String body;

    private HttpResponse() {
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    public String getProtocol() {
        return protocol;
    }



    public static ResponseBuilder createBuilder() {
        return new ResponseBuilder();
    }

    public static class ResponseBuilder {
        private HttpResponse response;

        public ResponseBuilder(){
            this.response = new HttpResponse();
        }

        public ResponseBuilder withStatusCode(int statusCode){
            this.response.statusCode = statusCode;
            return this;
        }

        public ResponseBuilder withProtocol(String protocol){
            this.response.protocol = protocol;
            return this;
        }

        public ResponseBuilder withHeaders(Map<String, String> headers){
            this.response.headers = headers;
            return this;
        }

        public ResponseBuilder addHeader(String header, String value) {
            if (this.response.headers == null) {
                this.response.headers = new HashMap<>();
            }
            this.response.headers.put(header, value);
            return this;
        }

        public ResponseBuilder withBody(String body){
            this.response.body = body;
            return this;
        }

        public HttpResponse build() {
            return response;
        }
    }


}
