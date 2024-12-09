package cn.itcast.mq.helloworld;

import cn.itcast.mq.SpringRabbitListener.SpringRabbitListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Title mq-demo
 * @Author hzl
 * @Date 2024/12/9 21:00
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerAMQPTest {

    @Test
    public void testConsumerAWQP(){
    }
}
