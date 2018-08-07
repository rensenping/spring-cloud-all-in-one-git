package com.jack.provider.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yangyueming
 */
@EnableDiscoveryClient
@SpringBootApplication
@EntityScan(basePackages={"com.jack.common.entity"})
public class ProviderUserApp {
  public static void main(String[] args) {
    SpringApplication.run(ProviderUserApp.class, args);
  }
}
