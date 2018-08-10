package com.cuc_nokia.chatrobot.messagequeue;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

/**
 * Created by egou on 2018/8/10.
 */
public class MessageQueueConfig {
    @Bean
    public Queue task_queue() {return new Queue("task_queue");}

    @Profile("receiver")
    private static class ReceiverConfig {
        @Bean
        public MessageReceiver receiver1() {return new MessageReceiver(1);}

        @Bean
        public MessageReceiver receiver2() {return new MessageReceiver(2);}
    }

    @Profile("sender")
    @Bean
    public MessageSender sender(){return new MessageSender();}
}
