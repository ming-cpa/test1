package sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {
	
	
	public static void main(String[] args) {
		System.out.println("starting up");
		
		SpringApplication.run(Application.class, args);
	}
	
	
}
