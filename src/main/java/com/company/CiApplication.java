package com.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class CiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CiApplication.class, args);
	}

}
