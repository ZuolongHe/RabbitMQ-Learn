package cn.itcast.mq.helloworld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

}
