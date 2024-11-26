package com.redis;

import com.redis.service.DriverService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RedisCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisCacheApplication.class, args);
	}

	@Bean
	ApplicationRunner runner(DriverService driverService) {
		return args -> {
			System.out.println("----------");
			System.out.println("Id 1: " + driverService.getById(1L).getDriverName());
			System.out.println("Id 2: " + driverService.getById(2L).getDriverName());
			System.out.println("Id 3: " + driverService.getById(3L).getDriverName());
			System.out.println("Id 2: " + driverService.getById(2L).getDriverName());
			System.out.println("----------");
		};
	}

}
