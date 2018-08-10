package com.cuc_nokia.chatrobot.messagequeue;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

/**
 * Created by egou on 2018/8/10.
 */
@RabbitListener(queues = "task_queue")
public class MessageReceiver
{
    private final int instance;
    public MessageReceiver(int i) {this.instance = i;}

    @RabbitHandler
    public void receive(String in) throws InterruptedException {
        StopWatch watch = new StopWatch();
        watch.start();
        System.out.println("instance" + this.instance + "[x] Received " + in + "'");
        doWork(in);
        watch.stop();
        System.out.println("instance " + this.instance + " [x] Done in " + watch.getTotalTimeSeconds() + "s");
    }

    private void doWork(String in) throws InterruptedException {
        for (char ch : in.toCharArray()) {
            if(ch == '.') {
                Thread.sleep(1000);
            }
        }
    }
}
