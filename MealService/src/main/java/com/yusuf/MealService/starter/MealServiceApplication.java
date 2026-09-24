package com.yusuf.MealService.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.yusuf"})
@ComponentScan(basePackages = {"com.yusuf"})
@EnableJpaRepositories(basePackages = {"com.yusuf"})
@EnableFeignClients(basePackages = { "com.yusuf" })
@SpringBootApplication
public class MealServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MealServiceApplication.class, args);
	}

}
