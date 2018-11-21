package com.itmuch.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

/**
 * @author yangyueming
 */
@Configuration
public class FeignLogConfig {
  @Bean
  Logger.Level feignLoggerLevel() {
    return Logger.Level.BASIC;
  }
}
