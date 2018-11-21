package com.jack.consumer.movie.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yangyueming
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class ConsumerMovieFeignApp {
  public static void main(String[] args) {
    SpringApplication.run(ConsumerMovieFeignApp.class, args);
  }
}
