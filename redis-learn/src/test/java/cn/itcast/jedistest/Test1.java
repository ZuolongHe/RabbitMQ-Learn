package cn.itcast.jedistest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

/**
 * @Title mq-demo
 * @Author hzl
 * @Date 2024/12/21 16:01
 * @Description
 */
@Slf4j
public class Test1 {
    private Jedis jedis;

    @BeforeEach // junit注解用于标记一个方法，该方法将在每个测试方法执行之前被调用
    public void setJedis(){
        try {
            jedis = new Jedis("192.168.163.131", 6379);
            // jedis.auth("123456");
            jedis.select(0);
            log.info("连接成功");
        } catch (Exception e) {
            e.printStackTrace();
            log.info("连接失败");
        }
    }

    @Test
    public void getJedis(){
        String result = jedis.set("kaer", "ka");
        System.out.println(result);
        String kaer = jedis.get("kaer");
        System.out.println(kaer);
    }

    @AfterEach //  junit注解用于标记一个方法，该方法将在每个测试方法执行之后被调用
    public void afterJedis(){
        if (jedis != null){
            jedis.close();
        }
    }


}
