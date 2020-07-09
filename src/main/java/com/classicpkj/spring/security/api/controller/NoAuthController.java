package com.classicpkj.spring.security.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/noauth/rest")
public class NoAuthController {
	
	@GetMapping("/sayhi")
	public String sayTestHi()
	{
		return "spring security example :";
	}
}
