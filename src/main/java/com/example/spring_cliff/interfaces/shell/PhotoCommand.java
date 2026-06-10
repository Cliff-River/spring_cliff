package com.example.spring_cliff.interfaces.shell;

import org.springframework.shell.core.command.annotation.CommandGroup;

import com.example.spring_cliff.core.photo.PhotoService;

@CommandGroup(name = "Photo Commands", description = "Commands for photo operations")
public class PhotoCommand {
    final PhotoService photoService;
    
    public PhotoCommand(PhotoService photoService) {
        this.photoService = photoService;
    }

    public  String showPhoto(String name) {
        return photoService.download(name).map(data -> "Photo " + name + " is shown").orElse("Photo " + name + " is not found");
    }
}
