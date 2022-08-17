package ru.geekbrains;

import ru.geekbrains.domain.HttpRequest;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class RequestParser {

    public static HttpRequest parse(Deque<String> rawRequest) {
        String[] parts = rawRequest.pollFirst().split(" ");

        Map<String, String> headers = new HashMap<>();
        StringBuilder body = new StringBuilder();
        String line = null;

        // parse headers
        while (true) {
            line = rawRequest.pollFirst();
            if (line.length() == 0) {
                break;
            }

            String[] header = line.split(": ");
            headers.put(header[0], header[1]);
        }
        // parse body
        rawRequest.forEach(e -> body.append(e));

        return new HttpRequest(parts[0], parts[1], headers, body.toString());
    }
}
