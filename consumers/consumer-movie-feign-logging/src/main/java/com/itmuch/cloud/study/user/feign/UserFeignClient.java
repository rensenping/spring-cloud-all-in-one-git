package com.itmuch.cloud.study.user.feign;

import com.itmuch.cloud.config.FeignLogConfig;
import com.jack.common.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "user", configuration = FeignLogConfig.class)
public interface UserFeignClient {
    @GetMapping(value = "/{id}")
    public User findById(@PathVariable("id") Long id);
}
