package com.example.spring_cliff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.unit.DataSize;
import com.example.spring_cliff.core.FileSystem;

@SpringBootApplication
public class SpringCliffApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(SpringCliffApplication.class, args);

		var fs = ctx.getBean(FileSystem.class);
		System.out.println("Free space: " + DataSize.ofBytes(fs.getFreeSpace()).toGigabytes() + "GB");
	}

}
