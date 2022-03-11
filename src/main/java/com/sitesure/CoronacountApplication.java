package com.sitesure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CoronacountApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronacountApplication.class, args);
	}

}
