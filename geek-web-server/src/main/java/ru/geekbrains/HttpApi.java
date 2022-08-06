package ru.geekbrains;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpApi {

    private String fileName;

    public void fetchFileName(BufferedReader input) throws IOException {
        String firstLine = input.readLine();
        String[] parts = firstLine.split(" ");

        this.fileName = parts[1];

        while (input.ready()) {
            System.out.println(input.readLine());
        }
    }

    public String getFileName() {
        return fileName;
    }
}
