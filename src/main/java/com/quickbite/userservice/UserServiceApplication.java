package com.quickbite.userservice;

import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserServiceApplication {

	private static final Logger log = LoggerFactory.getLogger(UserServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner verifyDatabaseConnection(DataSource dataSource) {
		return args -> {
			try (var connection = dataSource.getConnection()) {
				log.info("Successfully connected to PostgreSQL database: {} ({})",
						connection.getMetaData().getURL(),
						connection.getMetaData().getDatabaseProductVersion());
			}
		};
	}

}
