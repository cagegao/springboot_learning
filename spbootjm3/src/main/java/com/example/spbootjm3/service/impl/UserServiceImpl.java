package com.example.spbootjm3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spbootjm3.domain.City;
import com.example.spbootjm3.domain.User;
import com.example.spbootjm3.repository.cluster.CityRepository;
import com.example.spbootjm3.repository.master.UserRepository;
import com.example.spbootjm3.service.UserService;

/**
 * 用户业务实现层
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository; // 主数据源

	@Autowired
	private CityRepository cityRepository; // 从数据源

	@Override
	public User findByName(String userName) {
		User user = userRepository.findByName(userName);
		City city = cityRepository.findByName("温岭市");
		user.setCity(city);
		return user;
	}
}
