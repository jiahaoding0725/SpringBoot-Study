package com.ding.Controller.config;

// 扩展 Springmvc

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    // // public interface ViewResolver 实现了视图解析器接口的类，我们就可以把它看作视图解析器
    //     //
    //     // @Bean
    //     // public ViewResolver myViewResolver(){
    //     //     return new MyViewResolver();
    //     // }
    //     //
    //     //
    //     // // 自定义一个视图解析器
    //     // public static class MyViewResolver implements ViewResolver {
    //     //     @Override
    //     //     public View resolveViewName(String viewName, Locale locale) throws Exception {
    //     //         return null;
    //     //     }
    //     // }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/ding").setViewName("test");
    }
}


