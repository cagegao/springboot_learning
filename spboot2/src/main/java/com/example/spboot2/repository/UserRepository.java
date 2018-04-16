package com.example.spboot2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.spboot2.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

	// select * from user where name = ? and password = ?
	public User findByNameAndPassword(String name, String password);

	// select * from user where name like ?
	public User findByNameLike(String name);
}
