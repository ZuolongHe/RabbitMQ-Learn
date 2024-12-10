package cn.itcast.mq.SpringRabbitListener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Title mq-demo
 * @Author hzl
 * @Date 2024/12/9 21:30
 * @Description 监听队列消息
 */
@Slf4j
@Component
public class SpringRabbitListener {

    @RabbitListener(queues = "simple.queue")
    public void ListenSimpleQueue(String message) throws InterruptedException{
        log.info("第1监听器：监听到的消息:{}", message + LocalDateTime.now());
        Thread.sleep(20);
    }

    @RabbitListener(queues = "simple.queue")
    public void ListenSimpleQueueWork(String message) throws InterruptedException{
        log.info("第2监听器：监听到的消息:{}", message + LocalDateTime.now());
        System.err.println(message + LocalDateTime.now());
        Thread.sleep(200);
    }
}

