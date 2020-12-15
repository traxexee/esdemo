package com.emt.esdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in10:07 2020/12/15.
 * @Modified By:
 */
@EnableWebMvc
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/" };

/*
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AppInterceptor()).addPathPatterns("/**").excludePathPatterns("");
    }
*/


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置server虚拟路径，handler为页面中访问的目录，locations为files相对应的本地路径
        registry.addResourceHandler("/static/**")
                .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }

}
