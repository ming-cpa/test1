/*
 * Copyright 2014-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.mvc;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sample.model.User;
import sample.service.HelloWorldService;
import sample.service.RedisService;

@Controller
public class IndexController {
	
	@Autowired
	private HelloWorldService helloWorldService;

	@Autowired
	private RedisService redisService;

	@Autowired
	private JdkSerializationRedisSerializer stringSerializer;

	@Autowired
	private Environment env;
	
	@Value("${server.session.timeout}")
	private int sessiontimeout;
	@Value("${server.name}")
	private String servername;
	
	@RequestMapping("/")
	public String index(HttpServletRequest request) {
		request.setAttribute("servername", servername);	
		System.out.println(request.getContextPath());
		System.out.println("+++ Env :  " + env.getProperty("server.session.timeout"));
		
		return "index";
	}

	@RequestMapping("/welcome")
	public String getNewName(
			@RequestParam(value = "userName", defaultValue = "TestUser") String userName,
			HttpServletRequest request) {
		String newUserName = helloWorldService.getNewName(userName);
		String sessionid = request.getSession().getId();
		String redisStatus = redisService.ping();
   
		System.out.println("Login user: " + userName + ", Session: "
				+ sessionid);

		User usr;
		String msg;
		if (redisService.existsByteKey(userName)) {
			System.out.println(userName + " already login, get User from Redis");
			usr = (User) stringSerializer.deserialize(redisService
					.getSerializedObject(userName));
			msg = usr.getUsername() + " already logged in at " + usr.getLtime();
		} else {
			System.out.println(userName + " fist login save User to Redis");
			usr = new User(userName, "CPA - SME team", sessionid);
			redisService.setSerializedObject(userName, usr, sessiontimeout);
			msg = "User First logged in at " + usr.getLtime();
		}

		request.setAttribute("usr", usr);
		request.setAttribute("redisStatus", redisStatus);
		request.setAttribute("msg", msg);
		request.setAttribute("servername", servername);	
		
		return "welcome";
	}
	
	
	
}
