package com.example.spring_cliff.interfaces.shell;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.shell.core.command.annotation.Argument;
import org.springframework.shell.core.command.annotation.Command;
import org.springframework.shell.core.command.annotation.CommandGroup;

import com.example.spring_cliff.core.photo.PhotoService;

@CommandGroup(name = "Photo Commands", description = "Commands for photo operations")
public class PhotoCommand {
    final PhotoService photoService;
    
    public PhotoCommand(PhotoService photoService) {
        this.photoService = photoService;
    }

    @Command(description = "Show photo information")
    public  String showPhoto(@Argument(index = 0) String name) {
        return photoService.download(name).map(data -> {
            try {
                var image = ImageIO.read(new ByteArrayInputStream(data));
                return """
                         Image information:
                         Width: %d
                         Height: %d
                         Type: %s
                         """.formatted(image.getWidth(), image.getHeight(), image.getClass().getSimpleName());
            } catch (IOException e) {
                throw new RuntimeException("Failed to read image", e);
            }
        }).orElse("Photo " + name + " is not found");
    }
}
