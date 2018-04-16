package com.example.spbootjt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("primaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Override
	public void create(String name, String password) {
		jdbcTemplate.update("insert into USER(NAME, PASSWORD) values(?, ?)", name, password);
	}

	@Override
	public void deleteByName(String name) {
		jdbcTemplate.update("delete from USER where NAME = ?", name);
	}

	@Override
	public Integer getAllUsers() {
		return jdbcTemplate.queryForObject("select count(1) from USER", Integer.class);
	}

	@Override
	public void deleteAllUsers() {
		jdbcTemplate.update("delete from USER");
	}
}
