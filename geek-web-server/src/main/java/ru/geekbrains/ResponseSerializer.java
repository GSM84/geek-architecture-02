package ru.geekbrains;

import ru.geekbrains.domain.HttpResponse;

import java.util.Map;

public final class ResponseSerializer {

    public static String serialize(HttpResponse response) {
        StringBuilder sb = new StringBuilder();
        sb.append(response.getProtocol() + " ");
        sb.append(response.getStatusCode() + "\n");

        // headers
        for (Map.Entry<String, String > header: response.getHeaders().entrySet()){
            sb.append(header.getKey() + ": " + header.getValue() + "\n");
        }
        sb.append("\n");
        sb.append(response.getBody());

        return sb.toString();
    }
}
