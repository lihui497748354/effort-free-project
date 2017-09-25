package com.effort;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Effort_Fallow_Application {
	public static void main(String[] args) {
		SpringApplication.run(Effort_Fallow_Application.class, args);
	}
}
