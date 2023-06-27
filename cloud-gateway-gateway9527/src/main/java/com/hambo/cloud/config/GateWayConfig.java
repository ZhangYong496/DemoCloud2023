package com.hambo.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {

    //使用编码方式增加路由转发配置
    @Bean
    public RouteLocator myRouter(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                //path是uri的具体访问路径， uri是前缀
                .route("route1", r -> r.path("/hot").uri("https://www.zhihu.com"))
                .build();
    }



}
