package com.example.spbootjm3.service;

import com.example.spbootjm3.domain.User;

/**
 * 用户业务接口层
 *
 */
public interface UserService {

	/**
	 * 根据用户名获取用户信息，包括从库的地址信息
	 *
	 * @param userName
	 * @return
	 */
	User findByName(String userName);
}
