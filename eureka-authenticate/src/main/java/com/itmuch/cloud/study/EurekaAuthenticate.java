package com.itmuch.cloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author yangyueming
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaAuthenticate {
  public static void main(String[] args) {
    SpringApplication.run(EurekaAuthenticate.class, args);
  }
}
