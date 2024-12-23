package cn.itcast.mq.SpringRabbitListener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import sun.security.krb5.internal.crypto.EType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * @Title mq-demo
 * @Author hzl
 * @Date 2024/12/9 21:30
 * @Description 监听队列消息
 */
@Slf4j
@Component
public class SpringRabbitListener {

//    @RabbitListener(queues = "simple.queue")
//    public void ListenSimpleQueue(String message) throws InterruptedException{
//        log.info("第1监听器：监听到的消息:{}", message + LocalDateTime.now());
//        Thread.sleep(20);
//    }
//
//    @RabbitListener(queues = "simple.queue")
//    public void ListenSimpleQueueWork(String message) throws InterruptedException{
//        log.info("第2监听器：监听到的消息:{}", message + LocalDateTime.now());
//        System.err.println(message + LocalDateTime.now());
//        Thread.sleep(200);
//    }

    // 消费者监听queue1
    @RabbitListener(queues = "queue1")
    public void LinstenQueue1(String message){
        log.info("监听消息：{}", message);
    }


    // 消费者监听queue2
    @RabbitListener(queues = "queue2")
    public void LinstenQueue2(String message){
        log.info("监听消息：{}", message);
    }

    // 交换机Direct模式
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("direct.queue1"),
            exchange = @Exchange(value = "itcast.direct", type = ExchangeTypes.DIRECT),
            key = {"red", "blue"}))
    public void direct1(String message){
        log.info("direct1 message:{}", message);
    }

    // 交换机Direct模式
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("direct.queue2"),
            exchange = @Exchange(value = "itcast.direct", type = ExchangeTypes.DIRECT),
            key = {"blue"}))
    public void direct2(String message){
        log.info("direct2 message:{}", message);
    }


    // topic话题模式
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("topic.queue1"),
            exchange = @Exchange(value = "topic.exchange", type = ExchangeTypes.TOPIC),
            key = {"#.china"}
    ))
    public void topic1(String message){
        log.info("接收消息1：{}", message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("topic.queue2"),
            exchange = @Exchange(value = "topic.exchange", type = ExchangeTypes.TOPIC),
            key = {"news.#"}
    ))
    public void topic2(String message){
        log.info("接收消息2：{}", message);
    }

    @RabbitListener(queues = "simple.queue")
    public void messageConverter(Map<String, Object> map){
        log.info("{}", map);
    }

}

