package com.jack.provider.user.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author yangyueming
 */
@Configuration
@EntityScan(basePackages = {"com.jack.common.entity"})
@EnableJpaRepositories(basePackages = {"com.jack.common.repository"})
public class JpaConfig {
}
