package com.example.spring_cliff.core;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Component;

@Component
public class FileSystem {
    private static final String IMAGES_PATH = "images/";

    public long getFreeSpace() {
        return 0;
    }

    public byte[] load(String filename) throws IOException {
        String resourcePath = IMAGES_PATH + filename;
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(resourcePath)) {
            if (is == null) {
                throw new IOException("Resource not found: " + resourcePath);
            }
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }

    public void store(String filename, byte[] data) throws IOException {
        throw new UnsupportedOperationException("Storing files is not supported for classpath resources");
    }
}
