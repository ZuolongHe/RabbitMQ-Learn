package cn.itcast.mq.helloworld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title mq-demo
 * @Author hzl
 * @Date 2024/12/9 20:32
 * @Description
 */
@RunWith(SpringRunner.class)  // 加载 Spring 应用上下文，允许在测试中注入 Spring 的 Bean。提供对依赖注入（DI）、事务管理等 Spring 功能的支持。
@SpringBootTest  // 启动整个Spring Boot应用上下文。可加载完整的 Spring Boot 配置，包括application.properties 或 application.yml。允许测试 Web 层、服务层、数据层等多种功能。
public class SpringAMQPTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void TestAMQP() throws InterruptedException {
        String queue = "simple.queue";  // 声明队列名称
        String message = "测试消息--"; // 声明要发送的消息
        for (int i = 1; i <= 1000; i++) {
            rabbitTemplate.convertAndSend(queue, message + i + "--");
            Thread.sleep(20);
        }
    }

    // 广播
    @Test
    public void Fanout(){
        String exchange = "Fanout-exchange";
        String message = "广播消息";
        rabbitTemplate.convertAndSend(exchange, "", message);
    }

    // 直连
    @Test
    public void direct(){
        String exchange = "itcast.direct";
        String message = "Direct消息!";
        String[] routingKey = {"red", "blue"};
        for (int i = 0; i < routingKey.length; i++) {
            rabbitTemplate.convertAndSend(exchange, routingKey[i], message);
        }
    }

    @Test
    public void topic(){
        String exchange = "topic.exchange";
        String message = "Direct消息!";
        String[] routingKey = {"news.h", "news.k", "sd.china"};
        for (int i = 0; i < routingKey.length; i++) {
            rabbitTemplate.convertAndSend(exchange, routingKey[i], message);
        }
    }

    @Test
    public void messageConverter(){
        String queue = "simple.queue";
        Map<String, Object> map = new HashMap<>();
        map.put("1", "消息1");
        map.put("2", "消息2");
        rabbitTemplate.convertAndSend(queue, map);
    }
}
