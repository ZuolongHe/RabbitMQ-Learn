package cn.itcast.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @Title mq-demo
 * @Author hzl
 * @Date 2024/12/21 20:58
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDemoApplicationTests {

    // 注入redisTemplate
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Test
    public void testRedisTemplate(){
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setValueSerializer(stringRedisSerializer);
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.opsForValue().set("name", "张老三");
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println("name" + name);
    }

}
