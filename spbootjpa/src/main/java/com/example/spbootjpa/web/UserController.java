package com.example.spbootjpa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spbootjpa.domain.p.User;
import com.example.spbootjpa.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/user/{name}/detail")
	public User showDetail(@PathVariable("name") String name) throws Exception {
		return userService.queryUserByName(name);
	}

	@RequestMapping(path = "/users/{pageNum}")
	public List<User> showUsers(@PathVariable("pageNum") Integer pageNum) throws Exception {
		System.out.println("当前页数:" + pageNum);
		Page<User> users = userService.search(pageNum != null ? (pageNum >= 1 ? pageNum : 1) : 1);
		return users.getContent();
	}

	@RequestMapping(path = "/users/{pageNum}/{name}")
	public List<User> showUsers(@PathVariable("pageNum") Integer pageNum, @PathVariable("name") String name)
			throws Exception {
		System.out.println("当前页数:" + pageNum);
		Page<User> users = userService.search(pageNum != null ? pageNum : 1, name);
		return users.getContent();
	}
}
