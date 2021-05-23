package com.ding.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// 本身就是Spring的一个组件

// http://localhost:8080/hello
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello, World";
    }
}
