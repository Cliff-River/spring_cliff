package com.example.spring_cliff;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.util.unit.DataSize;

import com.example.spring_cliff.core.FileSystem;

@SpringBootApplication
public class SpringCliffApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(SpringCliffApplication.class, args);

		var fs = ctx.getBean(FileSystem.class);
		System.out.println("Free space: " + DataSize.ofBytes(fs.getFreeSpace()).toGigabytes() + "GB");
	}

	@Bean
	public PromptProvider myPromptProvider() {
		return () -> new AttributedString("Spring Cliff->", AttributedStyle.DEFAULT.foreground(AttributedStyle.GREEN));
	}
}
