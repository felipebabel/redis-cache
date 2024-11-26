package com.redis.service;

import com.redis.util.Driver;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DriverService {

    Map<Long, Driver> driver = new HashMap<>() {{
        put(1L, new Driver(1L, "Charles Lecrerc", "Monaco"));
        put(2L, new Driver(2L, "Max Verstappen", "Dutch"));
        put(3L, new Driver(3L, "Lewis Hamilton", "England"));
        put(4L, new Driver(4L, "Lando Norris", "England"));
    }};

    public Driver getById(Long id) throws InterruptedException {
        System.out.println("Finding Driver");
        Thread.sleep(1000L);
        return driver.get(id);
    }
}
