package com.redis.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DriverWithoutCache {

    final Long id;
    final String driverName;
    final String country;

}
