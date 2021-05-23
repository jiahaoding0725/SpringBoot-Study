package com.example.demo.controller;

import com.example.demo.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping("/user")
    public User user(){
        return new User();
    }

    @ApiOperation("Hello控制接口")
    @GetMapping("/hello")
    public String hello2(@ApiParam("用户名") String username) {
        return "hello" + username;
    }

    @ApiOperation("get测试")
    @GetMapping("/get")
    public User hello2(@ApiParam("用户") User user) {
        return user;
    }
}
