package com.itmuch.cloud.study.user.controller;

import com.jack.common.entity.User;
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
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return this.restTemplate.getForObject("http://microservice-provider-user/" + id, User.class);
    }

    @GetMapping("/log-user-instance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
        // 打印当前选择的是哪个节点
        MovieController.log.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
    }
}
