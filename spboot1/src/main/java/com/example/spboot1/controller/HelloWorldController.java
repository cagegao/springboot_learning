package com.example.spboot1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //被@RestController注解的控制器中的所有方法默认都是返回json格式的数据
public class HelloWorldController {

	@RequestMapping("/hello")
	public String index() {
		return "Hello World!!!";
	}
}
