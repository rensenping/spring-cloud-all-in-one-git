package com.itmuch.cloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

/**
 * @author yangyueming
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulRegExp {

    public static void main(String[] args) {
        SpringApplication.run(ZuulRegExp.class, args);
    }

    @Bean
    public PatternServiceRouteMapper serviceRouteMapper() {
        // 调用构造函数PatternServiceRouteMapper(String servicePattern, String routePattern)
        // servicePattern指定微服务的正则
        // routePattern指定路由正则
        return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)", "${version}/${name}");
    }
}
