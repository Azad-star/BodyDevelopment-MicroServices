package com.yusuf.WorkOutNutritionService.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = { "com.yusuf" })
@ComponentScan(basePackages = { "com.yusuf" })
@EnableJpaRepositories(basePackages = { "com.yusuf" })
@SpringBootApplication
public class WorkOutNutritionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkOutNutritionServiceApplication.class, args);
	}

}
