package sample.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
public class RedisConfig {
	
	@Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }
	
	@Bean  
    public JdkSerializationRedisSerializer jdkSerializer() {  
        return new JdkSerializationRedisSerializer();  
    }
	
	@Bean  
    public StringRedisSerializer stringSerializer() {  
        return new StringRedisSerializer();  
    }


	/*@Bean
    public RedisTemplate<?, ?> redisTemplate(JedisConnectionFactory factory) {
        RedisTemplate<?, ?> template = new RedisTemplate();
        return template;
    }*/
	
//	<bean id="jsonSerializer" class="com.sample.redis.sdr.JsonRedisSerializer"/>
	
	
    

}
