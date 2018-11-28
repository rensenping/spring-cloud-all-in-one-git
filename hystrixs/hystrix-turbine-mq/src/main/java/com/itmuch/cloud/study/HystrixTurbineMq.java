package com.itmuch.cloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

/**
 * @author yangyueming
 */
@SpringBootApplication
@EnableTurbineStream
public class HystrixTurbineMq {
    public static void main(String[] args) {
        SpringApplication.run(HystrixTurbineMq.class, args);
    }
}
