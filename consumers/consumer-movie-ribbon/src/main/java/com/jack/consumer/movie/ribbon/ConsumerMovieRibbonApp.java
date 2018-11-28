package com.jack.consumer.movie.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 * @author yangyueming
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerMovieRibbonApp {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMovieRibbonApp.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
