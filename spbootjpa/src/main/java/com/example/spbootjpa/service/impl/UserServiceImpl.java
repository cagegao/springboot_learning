package com.example.spbootjpa.service.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.spbootjpa.domain.p.User;
import com.example.spbootjpa.domain.p.UserRepository;
import com.example.spbootjpa.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User queryUserByName(String name) throws Exception {
		return userRepository.findUser(name);
	}

	@Override
	public Page<User> search(Integer page) {
		int size = 10;
		Sort sort = new Sort(Direction.ASC, "name");
		Pageable pageable = new PageRequest(page - 1, size, sort);
		Page<User> users = userRepository.findAll(pageable);
		return users;
	}

	@Override
	public Page<User> search(Integer page, String name) {
		int size = 10;
		Sort sort = new Sort(Direction.ASC, "name");
		Pageable pageable = new PageRequest(page - 1, size, sort);
		return userRepository.findAll(new Specification<User>() {
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// 查询条件
				Predicate nameLike = null;
				if (name != null && !StringUtils.isEmpty(name)) {
					nameLike = cb.like(root.<String>get("name"), "%" + name + "%");
				}

				if (null != nameLike) {
					query.where(nameLike);
				}
				return null;
			}
		}, pageable);
	}

}
