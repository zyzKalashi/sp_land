package com.kailash.land.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @Author: jinjx
 * @Date: Create in 2018/4/25
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * 添加静态资源
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //过滤swagger
        registry.addResourceHandler("/templates/**")
                .addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/templates/");
        registry.addResourceHandler("/templates/common/**")
                .addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/templates/common/");
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");

    }
}
