package com.atharva.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping("/hello")
	public String syaHello() {
		System.out.println("hello");
//		return new ModelAndView("hello");
		return "hello";

	}
}
