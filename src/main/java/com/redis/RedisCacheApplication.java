package com.redis;

import com.redis.service.DriverService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;
import java.util.logging.Logger;

@SpringBootApplication
@EnableCaching
public class RedisCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisCacheApplication.class, args);
    }

    @Bean
    ApplicationRunner runner(DriverService driverService) {
        return args -> {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("----------");
                String continueRunning = "y";

                while ("y".equals(continueRunning)) {
                    System.out.print("Do you want to run the project with redis? (y/n)");
                    String redisYesNo = scanner.next();

                    while (redisYesNo.length() != 1 || (!redisYesNo.equalsIgnoreCase("y") && !redisYesNo.equalsIgnoreCase("n"))) {
                        System.out.print("Invalid input. Please enter 'y' or 'n': ");
                        redisYesNo = scanner.next();
                    }

                    if ("y".equals(redisYesNo)) {
                        try {
                            System.out.println("----------");
                            System.out.println("Id 1: " + driverService.getDriverWithCacheById(1L).getDriverName());
                            System.out.println("Id 2: " + driverService.getDriverWithCacheById(2L).getDriverName());
                            System.out.println("Id 3: " + driverService.getDriverWithCacheById(3L).getDriverName());
                            System.out.println("Id 2: " + driverService.getDriverWithCacheById(2L).getDriverName());
                            System.out.println("----------");
                        } catch (Exception e) {
                            System.out.println("Error: Redis is not open or another issue occurred.");
                            System.exit(1);
                        }

                    } else {
                        System.out.println("----------");
                        System.out.println("Id 1: " + driverService.getDriverWithoutCacheById(1L).getDriverName());
                        System.out.println("Id 2: " + driverService.getDriverWithoutCacheById(2L).getDriverName());
                        System.out.println("Id 3: " + driverService.getDriverWithoutCacheById(3L).getDriverName());
                        System.out.println("Id 2: " + driverService.getDriverWithoutCacheById(2L).getDriverName());
                        System.out.println("----------");
                    }
                    System.out.print("Do you want to run the project again? (y)");
                    continueRunning = scanner.next();
                }

            }
        };
    }

}
