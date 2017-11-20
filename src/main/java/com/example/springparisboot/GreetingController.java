package com.example.springparisboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Controller
public class GreetingController {

	@Autowired
	CounterService counterService;

        @Value("${vcap.application.space_name:Local}")
	String env; 

	@RequestMapping("/")
	public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
       counterService.increment("spring.paris.attendees.view");
			 model.addAttribute("name", env);
			 return "greeting";
	}

}
