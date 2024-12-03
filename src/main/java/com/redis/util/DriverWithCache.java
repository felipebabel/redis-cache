package com.redis.util;
import java.io.Serializable;

public record DriverWithCache(Long id, String driverName, String country) implements Serializable {

}
