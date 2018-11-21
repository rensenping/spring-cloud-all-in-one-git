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
@EntityScan(basePackages={"com.jack.common.entity"})
@EnableJpaRepositories(basePackages = {"com.jack.common.repository"})
public class ProviderUser {
  public static void main(String[] args) {
    SpringApplication.run(ProviderUser.class, args);
  }
}
