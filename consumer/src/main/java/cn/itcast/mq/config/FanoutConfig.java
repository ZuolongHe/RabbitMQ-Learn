package cn.itcast.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Title mq-demo
 * @Author hzl
 * @Date 2024/12/10 13:23
 * @Description 广播路由
 */
@Configuration
public class FanoutConfig {

    // 声明交换机exchange
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("Fanout-exchange");
    }

    // 声明队列queue1
    @Bean
    public Queue fanoutQueue1() {
        return new Queue("queue1");
    }

    // 交换机绑定队列queue1
    @Bean
    public Binding bind1(FanoutExchange fanoutExchange, Queue fanoutQueue1) {
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }

    // 声明队列queue2
    @Bean
    public Queue fanoutQueue2(){
        return new Queue("queue2");
    }

    // 交换机绑定队列queue1
    @Bean
    public Binding bind2(FanoutExchange fanoutExchange, Queue fanoutQueue2){
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);

    }

}
