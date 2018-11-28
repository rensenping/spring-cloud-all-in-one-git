package com.itmuch.cloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author yangyueming
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulFallback {
    public static void main(String[] args) {
        SpringApplication.run(ZuulFallback.class, args);
    }
}
