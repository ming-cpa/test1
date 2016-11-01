package sample.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Service;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisServer;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.util.ByteUtils;

import redis.clients.jedis.Jedis;
import sample.service.RedisService;

@Service(value = "redisService")
public class RedisServiceImpl implements RedisService {

	
	private static String REDIS_CODE = "ISO-8859-1"; //utf-8 unable to recover serialized str
	private static Jedis jedis;

	private RedisServiceImpl() {

	}

	@Autowired
	@Qualifier("jedisConnectionFactory")
	private JedisConnectionFactory jedisConnectionFactory;

	@Autowired
	private JdkSerializationRedisSerializer stringSerializer;

	@Autowired
	private Jedis getJedis() {
		if (jedis == null) {
			return jedisConnectionFactory.getShardInfo().createResource();
		}
		return jedis;
	}

	public boolean exists(String key) {
		return this.getJedis().exists(key);

	}

	public boolean existsByteKey(String key) {
		return this.getJedis().exists(key);

	}

	public void del(String key) {
		this.getJedis().del(key);

	}

	public String getString(String key) {
		String value = this.getJedis().get(key);
		return value;

	}

	public void setString(String key, String value) {
		this.getJedis().set(key, value);
	}

	public void setSerializedObject(String skey, Object o, int timeout) {
		try {
			byte[] obj = stringSerializer.serialize(o);			
			String str = new String(obj, REDIS_CODE);
			// System.out.println(str);
			this.getJedis().setex(skey, timeout, str);
		} catch (Exception e) {

		}
	}

	public byte[] getSerializedObject(String key) {
		try {
			String str = this.getJedis().get(key);
			// System.out.println(str);			
			return str.getBytes(REDIS_CODE);
			
		} catch (Exception e) {
			
			return null;
		}

	}

	public String ping() {
		return this.getJedis().ping();

	}

	public String flushDB() {
		return this.getJedis().flushDB();

	}

}
