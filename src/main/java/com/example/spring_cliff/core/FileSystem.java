package com.example.spring_cliff.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;

@Component
public class FileSystem {
    private final Path root = Paths.get(System.getProperty("user.home")).resolve("fs");

    public FileSystem() {
        if (!Files.exists(root)) {
            try {
                Files.createDirectories(root);
            } catch (IOException e) {
                throw new RuntimeException("Failed to create file system root directory", e);
            }
        }
    }

    public long getFreeSpace() {
        return root.toFile().getFreeSpace();
    }

    public byte[] load(String filename) throws IOException {
        return Files.readAllBytes(root.resolve(filename));
    }

    public void store(String filename, byte[] data) throws IOException {
        Files.write(root.resolve(filename), data);
    }
}
