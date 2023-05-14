package com.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.event")
public class DtBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DtBackendApplication.class, args);
	}

}
