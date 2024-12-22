package cn.itcast;

import cn.itcast.redis.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
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
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private User user;

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testRedisTemplate(){
        user.setName("测试");
        user.setAge(12);
        redisTemplate.opsForValue().set("user", user);
        Object reUser = redisTemplate.opsForValue().get("user");
        System.out.println(reUser);
    }

    @Test
    public void testStringRedisTemplate() throws JsonProcessingException {
        user.setName("hnu");
        user.setAge(12);
        // user对象转为json
        String s = objectMapper.writeValueAsString(user);
        stringRedisTemplate.opsForValue().set("userhnu", s);
        // 反序列化
        String s1 = stringRedisTemplate.opsForValue().get("userhnu");
        // json转为user
        User user = objectMapper.readValue(s1, User.class);
        System.out.println(user);
    }

}
