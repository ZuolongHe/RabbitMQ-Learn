package cn.itcast.mq.SpringRabbitListener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

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
    public void ListenSimpleQueue(String message){
        log.info("监听到的消息:{}", message);
    }
}

