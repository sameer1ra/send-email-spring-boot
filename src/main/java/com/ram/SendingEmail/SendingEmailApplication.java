package com.ram.SendingEmail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SendingEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SendingEmailApplication.class, args);

	}

}
