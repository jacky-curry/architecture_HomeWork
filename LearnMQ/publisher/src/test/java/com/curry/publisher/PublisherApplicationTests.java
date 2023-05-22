package com.curry.publisher;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class PublisherApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    double[] longitude = new double[]{116.397128,115.905489,120.810885,121.316256,114.570650};
    double[] latitude = new double[]{23.354482,27.354482,28.354482,26.206517,23.696654};

    @Test
    public void testSimpleQueue(){
        // 队列名称
        String queueName = "simple.queue";
        // 消息
        String message = "hello, spring amqp!";
        // 发送消息
        rabbitTemplate.convertAndSend(queueName, message);
    }

    @Test
    public void testWorkQueue() throws InterruptedException {
        // 队列名称
        String queueName = "simple.queue";
        // 消息
        String message = "car, number_";
        for (int i = 0; i < 50; i++) {
            // 发送消息
            String position = "(" + longitude[(i % 5)] + "," + latitude[(i % 5)] + ")";
            rabbitTemplate.convertAndSend(queueName,message + i + "--- position: " + position);
            Thread.sleep(20);
        }
    }

}
