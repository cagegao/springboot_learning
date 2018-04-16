package com.example.spbootjpa.service;

import org.springframework.data.domain.Page;

import com.example.spbootjpa.domain.p.User;

public interface UserService {

	User queryUserByName(String name) throws Exception;

	Page<User> search(Integer page);

	Page<User> search(Integer page, String name);
}
