package sample.mvc;

import sample.model.WSGreeting;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WSGreetingController {
	
	 private static final String template = "Hello %s!";
	    private final AtomicLong counter = new AtomicLong();

	    @RequestMapping(value="/greeting" , method = RequestMethod.GET)
	    public WSGreeting greetingGet(@RequestParam(value="name", defaultValue="World") String name) {
	        return new WSGreeting(counter.incrementAndGet(),
	                            String.format(template, name + ""));
	    }
	    
	    @RequestMapping(value="/greeting2" , method = RequestMethod.GET)
	    public List<WSGreeting> greeting2(@RequestParam(value="name", defaultValue="World") String name) {
	        List<WSGreeting> list=new ArrayList<WSGreeting>();
	        list.add(new WSGreeting(counter.incrementAndGet(),
	                String.format(template, name)));
	        list.add(new WSGreeting(counter.incrementAndGet(),
	                String.format(template, name)));
	        return list;
	    }
	    @RequestMapping(value="/greeting3" , method = RequestMethod.GET)
	    public String greeting3(@RequestParam(value="name", defaultValue="World") String name) {
	    	counter.set(0);
	        return "Reset";
	    }

}
