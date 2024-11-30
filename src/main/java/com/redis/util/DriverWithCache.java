package com.redis.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class DriverWithCache implements Serializable {

    final Long id;
    final String driverName;
    final String country;

}
