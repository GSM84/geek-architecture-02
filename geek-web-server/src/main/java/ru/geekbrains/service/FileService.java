package ru.geekbrains.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileService {
    private final String rootDir;

    public FileService(String rootDir) {
        this.rootDir = rootDir;
    }

    public boolean exists(String fileName) {
        return Files.exists(Path.of(rootDir, fileName));
    }

    public boolean isDirectory(String fileName){
        return Files.isDirectory(Path.of(rootDir, fileName));
    }

    public String readFile(String fileName) {
        try {
            StringBuilder sb = new StringBuilder();
            Files.readAllLines(Path.of(rootDir, fileName)).forEach(sb::append);
            return sb.toString();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
