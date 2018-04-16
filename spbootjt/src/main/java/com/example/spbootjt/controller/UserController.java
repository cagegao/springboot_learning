package com.example.spbootjt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spbootjt.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/regist/{name}/{password}")
	public Map<String, String> regist(@PathVariable String name, @PathVariable String password) throws Exception {

		userService.create(name, password);
		Map<String, String> user = new HashMap<String, String>();
		user.put("name", name);
		user.put("password", password);

		return user;
	}
}
