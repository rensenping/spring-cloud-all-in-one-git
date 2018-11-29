package com.itmuch.cloud.study.user.controller;

import com.itmuch.cloud.study.user.service.UserService;
import com.jack.common.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author yangyueming
 */
@RestController
@Slf4j
public class MovieController {
    @Autowired
    private UserService userService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @HystrixCommand(fallbackMethod = "findByIdFallback")
    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    public User findByIdFallback(Long id, Throwable throwable) {
        User user = new User();
        user.setId(-1L);
        user.setName("the default user");
        return user;
    }

    @HystrixCommand(fallbackMethod = "findByIdFallback2")
    @GetMapping("/user2/{id}")
    public User findById2(@PathVariable Long id) {
        return restTemplate.getForObject("http://microservice-provider-user/" + id, User.class);
    }

     //如果想要获得导致fallback的原因，只需在fallback方法上添加Throwable参数即可。
    public User findByIdFallback2(Long id, Throwable throwable) {
        log.error("进入回退方法，异常：", throwable);
        User user = new User();
        user.setId(-1L);
        user.setName("默认用户");
        return user;
    }

    @GetMapping("/log-user-instance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-provider-user");
        // 打印当前选择的是哪个节点
        log.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
    }
}
