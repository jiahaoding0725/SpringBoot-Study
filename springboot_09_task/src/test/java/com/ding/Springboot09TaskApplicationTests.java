package com.ding;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot09TaskApplicationTests {

    @Autowired
    JavaMailSenderImpl javaMailSender;
    @Test//邮件设置1：一个简单的邮件
    void contextLoads() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("狂神，你好");
        mailMessage.setText("谢谢你的狂神说Java系列课程");

        mailMessage.setTo("24736743@qq.com");
        mailMessage.setFrom("1710841251@qq.com");
        javaMailSender.send(mailMessage);
    }

    @Test// 一个复杂的邮件
    void contextLoads2() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        //正文
        helper.setSubject("狂神，你好~plus");
        helper.setText("<p style='color:red'>谢谢你的狂神说Java系列课程</p>", true);

        //附件
        helper.addAttachment("1.jpg", new File(""));
        helper.addAttachment("2.jpg", new File(""));

        helper.setTo("24736743@qq.com");
        helper.setFrom("1710841251@qq.com");

        javaMailSender.send(mimeMessage);

    }
}
