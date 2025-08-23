package com.restaurant.productmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.restaurant.productmanagement.repository")
@EntityScan(basePackages = "com.restaurant.productmanagement.model")
public class RestaurantProductManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestaurantProductManagementApplication.class, args);
	}
}
