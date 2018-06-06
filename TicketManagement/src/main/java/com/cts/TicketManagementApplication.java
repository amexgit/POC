package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.cts.model")
@ComponentScan(basePackages = "com.cts")
@EnableJpaRepositories(basePackages = "com.cts.repository")
public class TicketManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketManagementApplication.class, args);
	}	
}
