package com.itmuch.cloud.study.user.feign;

import com.jack.simple.consumer.movie.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;

import java.util.Map;

@FeignClient(name = "user")
public interface UserFeignClient {
    @GetMapping(value = "/{id}")
    public User findById(@PathVariable("id") Long id);

    // 该请求不会成功
    @GetMapping(value = "/get")
    public User get0(User user);

    @GetMapping(value = "/get",)
    public User get1(@RequestParam("id") Long id, @RequestParam("username") String username);

    @GetMapping(value = "/get")
    public User get2(@RequestParam Map<String, Object> map);

    @PostMapping(value = "/post")
    public User post(@RequestBody User user);
}
