package com.minedu.project.maintenance_management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;

@Configuration
public class WebContextConfig {
    @Bean
    RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }
}
