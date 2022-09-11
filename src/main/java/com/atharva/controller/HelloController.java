package com.atharva.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@GetMapping("/")
	public ModelAndView syaHello() {
		System.out.println("hello");
		return new ModelAndView("index");
//		return "hello";
	}
}
