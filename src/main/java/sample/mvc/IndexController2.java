package sample.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController2 {
	
	@Autowired
	private Environment env;
	
	@Value("${server.session.timeout}")
	private int sessiontimeout;
	@Value("${server.name}")
	private String servername;
	
	@RequestMapping("/")
	public String index(HttpServletRequest request) {

		request.setAttribute("servername", servername);	
		
		System.out.println("+++ index  ");
		
		return "index";
	}

	
	
	
}
