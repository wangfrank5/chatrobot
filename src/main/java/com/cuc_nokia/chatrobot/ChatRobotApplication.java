package com.cuc_nokia.chatrobot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
/**
 * Created by egou on 2018/8/10.
 */

@SpringBootApplication
@EnableScheduling
public class ChatRobotApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ChatRobotApplication.class, args);
    }
}
