package com.jack.swagger.zuul.config;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangyueming
 */
@Component
@Primary
public class SwaggerZuulConfig implements SwaggerResourcesProvider {
    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resourceList = new ArrayList();
        resourceList.add(swaggerResource("user", "/user/v2/api-docs", "1.0"));
        resourceList.add(swaggerResource("order", "/order/v2/api-docs", "1.0"));
        return resourceList;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }

}
