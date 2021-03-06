package com.itmuch.cloud.study.user.feign;

import com.jack.simple.consumer.movie.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface UserFeignClient {
    @GetMapping(value = "/{id}")
    public User findById(@PathVariable("id") Long id);
}
