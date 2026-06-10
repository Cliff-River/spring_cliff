package com.example.spring_cliff.core.photo;
import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.spring_cliff.core.FileSystem;

@Service
public class PhotoService {
    final FileSystem fs;
    
    public PhotoService(FileSystem fs) {
        this.fs = fs;
    }

    public Optional<byte[]> download(String name) {
        try {
            byte[] data = fs.load("unicorns/" + name + ".jpg");
            return Optional.of(data);
        } catch (IOException e) {
            return Optional.empty();
        }
    }
}
