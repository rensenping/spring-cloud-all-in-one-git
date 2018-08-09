package com.itmuch.cloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.itmuch.cloud.study.filters.pre.PreRequestLogFilter;

/**
 * @author yangyueming
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulFilter {
  public static void main(String[] args) {
    SpringApplication.run(ZuulFilter.class, args);
  }

  @Bean
  public PreRequestLogFilter preRequestLogFilter() {
    return new PreRequestLogFilter();
  }
}
