package com.itmuch.cloud.study.user.feign;

import com.itmuch.cloud.config.FeignConfiguration;
import com.jack.simple.consumer.movie.entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * 使用@FeignClient的configuration属性，指定feign的配置类。
 *
 */
@FeignClient(name = "user", configuration = FeignConfiguration.class)
public interface UserFeignClient {
    /**
     * 使用feign自带的注解@RequestLine
     *
     * @param id 用户id
     * @return 用户信息
     * @see https://github.com/OpenFeign/feign
     */
    @RequestLine("GET /{id}")
    public User findById(@Param("id") Long id);
}
