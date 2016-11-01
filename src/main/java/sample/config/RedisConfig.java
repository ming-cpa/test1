package sample.config;

import sample.model.EnvConf;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.JedisShardInfo;


/*

import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultClient;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;

*/

@Configuration
public class RedisConfig {

	private static String V_Token = "14d561f6-0500-71fc-b598-8acfcdd5b117";

	@Value("${spring.vault.schema}")
	private String vschema;

	@Value("${spring.vault.host}")
	private String vhost;

	@Value("${spring.vault.port}")
	private int vport;
	
	@Value("${spring.redis.host}")
	private String rhost;

	@Value("${spring.redis.port}")
	private int rport;
	
	@Value("${spring.redis.password}")
	private String rpwd;

	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {

		EnvConf eConf = new EnvConf();
		eConf.setRhost(rhost);
		eConf.setRport(rport);
		eConf.setRpwd(rpwd);
		
		/* comment out Vault for testing
		 * 
		 *  // Vault configuration
		VaultEndpoint vEndpoint = new VaultEndpoint();
		vEndpoint.setScheme(vschema);
		vEndpoint.setHost(vhost);
		vEndpoint.setPort(vport);

		VaultClient vClient = new VaultClient(new RestTemplate(), vEndpoint);
		VaultTemplate vTemplate = new VaultTemplate(vClient,
				new TokenAuthentication(V_Token));
		VaultResponseSupport<EnvConf> response = vTemplate.read("secret/myapp",
				EnvConf.class);
		EnvConf eConf = (EnvConf) response.getData();
		System.out.println("+++ Vault test :" + eConf.getRhost());
		
		*/

		JedisConnectionFactory jedis = new JedisConnectionFactory();
		jedis.setHostName(eConf.getRhost());
		jedis.setPassword(eConf.getRpwd());
		jedis.setPort(eConf.getRport());
		
		return jedis;
	}

	@Bean
	public JdkSerializationRedisSerializer jdkSerializer() {
		
		return new JdkSerializationRedisSerializer();
	}

	@Bean
	public StringRedisSerializer stringSerializer() {
		
		return new StringRedisSerializer();
	}

	/*
	 * @Bean public RedisTemplate<?, ?> redisTemplate(JedisConnectionFactory
	 * factory) { RedisTemplate<?, ?> template = new RedisTemplate(); return
	 * template; }
	 */

}