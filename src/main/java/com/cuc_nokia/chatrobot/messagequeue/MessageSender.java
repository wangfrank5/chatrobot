package com.cuc_nokia.chatrobot.messagequeue;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by egou on 2018/8/10.
 */
public class MessageSender {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue task_queue;
    int dots = 0;

    int count = 0;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        StringBuilder builder = new StringBuilder("Hello");
        if (dots++ == 3) {
            dots = 1;
        }
        for (int i = 0; i < dots; i++) {
            builder.append('.');
        }

        builder.append(Integer.toString(++count));
        String message = builder.toString();
        template.convertAndSend(task_queue.getName(), message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
