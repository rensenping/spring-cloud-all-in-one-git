package com.jack.swagger.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author yangyueming
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class SwaggerZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(SwaggerZuulApplication.class, args);
    }
}
