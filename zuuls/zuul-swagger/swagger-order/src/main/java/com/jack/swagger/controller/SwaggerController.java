package com.jack.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangyueming
 */
@RestController
@RequestMapping(value = "/order")
@Api(description = "order", basePath = "order")
public class SwaggerController {
    @PostMapping("/getOrder")
    @ApiOperation(value = "获取用户名称")
    @ApiImplicitParam(name = "order", value = "订单",required = true, dataType = "String")
    String getUsername(String order) {
        return "Hello World!" + order;
    }
}
