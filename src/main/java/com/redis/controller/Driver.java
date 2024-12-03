package com.redis.controller;

import com.redis.service.DriverService;
import com.redis.util.DriverWithCache;
import com.redis.util.DriverWithoutCache;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


public interface Driver {

    @Operation(
            summary = "Get all drivers without cache",
            description = "Retrieve a list of all drivers without using cache.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of drivers without cache"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @GetMapping("/drivers/without-cache")
    ResponseEntity<List<DriverWithoutCache>> getAllDriverWithoutCache() throws InterruptedException;

    @Operation(
            summary = "Get all drivers with cache",
            description = "Retrieve a list of all drivers using cache.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of drivers with cache"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @GetMapping("/drivers/with-cache")
    ResponseEntity<List<DriverWithCache>> getAllDriverWithCache() throws InterruptedException;
}
