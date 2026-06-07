package com.example.spring_cliff.interfaces.shell;

import org.springframework.shell.core.command.annotation.Command;
import org.springframework.shell.core.command.annotation.Argument;
import org.springframework.shell.core.command.annotation.CommandGroup;

@CommandGroup(name = "File System Commands", description = "Commands for demonstration purposes")
public class FsCommand {
    @Command(name = "hello", description = "Says hello to the user")
    public String hello(
            @Argument(index = 0, defaultValue = "World") String name) {
        return "Hello " + name + "!";
    }

    @Command(description = "Displays the amount of free disk space")
    public String FreeDiskSpace() {
        return "Free disk space: 100GB";
    }
}
