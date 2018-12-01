package com.jack.swagger;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author yangyueming
 */
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2Doc
public class SwaggerOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerOrderApplication.class, args);
    }
}
