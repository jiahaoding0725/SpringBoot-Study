package com.ding.service;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
@DubboService(interfaceClass = com.ding.service.TicketService.class)
public class UserService {

    // 想拿到provider-server提供的票，要去注册中心拿到服务
    @DubboReference(check = false) //引用，Pom坐标，可以定义路径相同的接口名
    TicketService ticketService;

    public void bugTicket(){
        String ticket = ticketService.getTicket();
        System.out.println("在注册中心买到"+ticket);
    }

}
