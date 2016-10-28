package sample.service.impl;

import org.springframework.stereotype.Service;

import sample.service.HelloWorldService;

@Service(value = "helloWorldService")
public class HelloWorldServiceImpl implements HelloWorldService {

	public String getNewName(String userName) {

		return "Hello, " + userName;
	}

}