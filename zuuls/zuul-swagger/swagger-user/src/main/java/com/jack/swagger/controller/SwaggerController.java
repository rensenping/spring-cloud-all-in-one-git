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
@RequestMapping(value = "/user")
@Api(description = "user", basePath = "user")
public class SwaggerController {

    @PostMapping("/getUsername")
    @ApiOperation(value = "获取用户名称")
    @ApiImplicitParam(name = "username", value = "用户名称",required = true, dataType = "String")
    String getUsername(String username) {
        return "Hello World!" + username;
    }
}
