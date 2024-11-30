package com.redis.service;

import com.redis.util.DriverWithCache;
import com.redis.util.DriverWithoutCache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DriverService {

    Map<Long, DriverWithCache> driverWithCacheMap = new HashMap<>() {{
        put(1L, new DriverWithCache(1L, "Charles Lecrerc", "Monaco"));
        put(2L, new DriverWithCache(2L, "Max Verstappen", "Dutch"));
        put(3L, new DriverWithCache(3L, "Lewis Hamilton", "England"));
        put(4L, new DriverWithCache(4L, "Lando Norris", "England"));
    }};

    Map<Long, DriverWithoutCache> driverWithoutCacheMap = new HashMap<>() {{
        put(1L, new DriverWithoutCache(1L, "Charles Lecrerc", "Monaco"));
        put(2L, new DriverWithoutCache(2L, "Max Verstappen", "Dutch"));
        put(3L, new DriverWithoutCache(3L, "Lewis Hamilton", "England"));
        put(4L, new DriverWithoutCache(4L, "Lando Norris", "England"));
    }};

    @Cacheable("driverWithCacheMap")
    public DriverWithCache getDriverWithCacheById(Long id) throws InterruptedException {
        System.out.println("Finding Driver");
        Thread.sleep(1000L);
        return driverWithCacheMap.get(id);
    }

    public DriverWithoutCache getDriverWithoutCacheById(Long id) throws InterruptedException {
        System.out.println("Finding Driver");
        Thread.sleep(1000L);
        return driverWithoutCacheMap.get(id);
    }
}
