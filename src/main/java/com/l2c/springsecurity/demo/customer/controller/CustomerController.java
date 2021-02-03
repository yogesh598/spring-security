package com.l2c.springsecurity.demo.customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

	@GetMapping("/list-customers")
	public String showHome() {
		return "list-customers";
	}
	
}
