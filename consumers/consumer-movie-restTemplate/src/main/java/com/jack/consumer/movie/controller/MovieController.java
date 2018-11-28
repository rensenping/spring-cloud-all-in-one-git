package com.jack.consumer.movie.controller;

import com.jack.common.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


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

    @Autowired
    private DiscoveryClient discoveryClient;

    // 接口的请求总数
    private int requestCount = 1;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        // 第一种方式：采用服务别名方式调用
        return this.restTemplate.getForObject("http://localhost:8000/" + id, User.class);
    }

    @GetMapping("/user/{id}")
    public User findById2(@PathVariable Long id) {
        // 第二种方式：直接调用，使用别名去注册中心获取对应的服务调用地址, 依赖ribbon的@loadBalanced
        // @loadBalanced让RestTemplate具有负载均衡能力
        return this.restTemplate.getForObject("http://user:8000/" + id, User.class);
    }

    @GetMapping("/log-user-instance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("provider-user");
        // 打印当前选择的是哪个节点
        log.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(),
                serviceInstance.getPort());
    }

    // 手写ribbon负责均衡
    @GetMapping("/ribbonMember")
    public String ribbonMember() {
        // 1 获取对应服务器远程调用地址
        String instancesUrl = getInstances() + "/getMember";
        log.info("instancesUrl: " + instancesUrl);

        // 2 可以直接使用httpclient技术实现远程调用
        return restTemplate.getForObject(instancesUrl, String.class);
    }

    private String getInstances() {
        List<ServiceInstance> instanceList = discoveryClient.getInstances("user");
        if (CollectionUtils.isEmpty(instanceList)) {
            return Strings.EMPTY;
        }

        // 获取服务器集群个数
        int instanceSize = instanceList.size();
        int serviceIndex = requestCount % instanceSize;
        requestCount++;
        return instanceList.get(serviceIndex).getUri().toString();
    }

}
