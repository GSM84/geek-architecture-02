package ru.geekbrains;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileApi {
    private Path path;
    private String folder;

    public FileApi(String folder) {
        this.folder = folder;
    }

    public void formatPath(String fileName) {
        this.path = Path.of(folder, fileName);
    }

    public boolean isFileExists(PrintWriter output){
        if (!Files.exists(path)) {
            output.println("HTTP/1.1 404 NOT_FOUND");
            output.println("Content-Type: text/html; charset=utf-8");
            output.println();
            output.println("<h1>Файл не найден!</h1>");
            output.flush();

            return false;
        }
        return true;
    }

    public void pushFile(PrintWriter output) throws IOException {
        output.println("HTTP/1.1 200 OK");
        output.println("Content-Type: text/html; charset=utf-8");
        output.println();

        Files.newBufferedReader(path).transferTo(output);
    }
}
