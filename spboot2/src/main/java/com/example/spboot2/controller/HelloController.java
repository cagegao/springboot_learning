package com.example.spboot2.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.spboot2.domain.User;

//@RestController
@Controller
@SessionAttributes(names = { "user", "books", "orderId" })
public class HelloController {

	private User user;

	@ModelAttribute
	public void init1() {
		System.out.println("init......");
	}

	@RequestMapping("/")
	public String index(Model model) throws Exception {
		model.addAttribute("host", "http://www.jd.com"); // 该键值对不会保存到session中

		user = new User();
		user.setName("Jack");
		user.setPassword("123456");
		user.setBirthday(new Date());
		model.addAttribute("user", user);

		List<String> books = Collections.synchronizedList(new ArrayList<String>());
		books.add("Java");
		books.add("Oracle");
		books.add("SpringBoot");
		model.addAttribute("books", books);

		model.addAttribute("orderId", 123);
		return "index";
	}

	@RequestMapping("/ok")
	public String ok() throws Exception {
		System.out.println("=====访问OK页面=====");
		return "admin/ok";
	}

	@RequestMapping("/order/detail/{id}")
	@ResponseBody
	public String detail(@PathVariable("id") int id) throws Exception {
		return "Some information about order " + id;
	}
}
