package com.redis.controller;

import com.redis.service.DriverService;
import com.redis.util.DriverWithCache;
import com.redis.util.DriverWithoutCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/drivers")
public class DriverController {

    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/cache")
    private ResponseEntity<List<DriverWithCache>> getAllDriverWithCache() throws InterruptedException {
        List<DriverWithCache> driverWithCacheList = new ArrayList<>();
        driverWithCacheList.add(driverService.getDriverWithCacheById(1L));
        driverWithCacheList.add(driverService.getDriverWithCacheById(2L));
        driverWithCacheList.add(driverService.getDriverWithCacheById(3L));
        driverWithCacheList.add(driverService.getDriverWithCacheById(4L));
        return ResponseEntity.ok(driverWithCacheList);
    }

    @GetMapping("/withoutCache")
    private ResponseEntity<List<DriverWithoutCache>> getAllDriverWithoutCache() throws InterruptedException {
        List<DriverWithoutCache> driverWithCacheList = new ArrayList<>();
        driverWithCacheList.add(driverService.getDriverWithoutCacheById(1L));
        driverWithCacheList.add(driverService.getDriverWithoutCacheById(2L));
        driverWithCacheList.add(driverService.getDriverWithoutCacheById(3L));
        driverWithCacheList.add(driverService.getDriverWithoutCacheById(4L));
        return ResponseEntity.ok(driverWithCacheList);
    }

}
