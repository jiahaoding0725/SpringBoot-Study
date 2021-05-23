package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2 // 开启Swagger2
public class SwaggerConfig {

    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("group1");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("group2");
    }
    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("group3");
    }

    // 配置了Swaggger的Docket的bean实例
    @Bean
    public Docket docket(Environment environment){

        // 设置要显示的Sagger环境
        Profiles of = Profiles.of("dev", "test");
        // 获得项目环境
        boolean b = environment.acceptsProfiles(of);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("丁家豪")
                .enable(b)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                // .paths(PathSelectors.ant("/ding/**"))
                .build();
    }

    // 配置Swagger信息apiInfo
    public ApiInfo apiInfo(){
        // 作者信息
        Contact contact = new Contact("丁家豪", "http://xxx.xxx.com/联系人访问链接", "1023921169@qq.com");

        return new ApiInfo("SwaggerAPi文档",
                "学习演示如何配置Swagger",
                "v1.0",
                "http://terms.service.url/组织链接",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>());
    }

}
