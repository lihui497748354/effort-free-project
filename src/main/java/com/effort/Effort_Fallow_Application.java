package com.effort;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Effort_Fallow_Application {
	public static void main(String[] args) {
		SpringApplication.run(Effort_Fallow_Application.class, args);
	}
}
