package com.jack.consumer.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author yangyueming
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerMovieRestTemplateApp {
  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  public static void main(String[] args) {
    SpringApplication.run(ConsumerMovieRestTemplateApp.class, args);
  }
}
