package com.jack.provider.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author yangyueming
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ProviderUser {
  public static void main(String[] args) {
    SpringApplication.run(ProviderUser.class, args);
  }
}
