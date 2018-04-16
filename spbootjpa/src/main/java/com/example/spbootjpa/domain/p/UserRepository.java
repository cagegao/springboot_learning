package com.example.spbootjpa.domain.p;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

	/* 使用方法名的方式解析生成SQL语句 */
	User findByName(String name);

	User findByNameAndAge(String name, Integer age);

	/* 使用JPQL语句的方式生成SQL语句，同时使用":name"的形似传递参数 */
	@Query("from User u where u.name=:name")
	User findUser(@Param("name") String name);

	/* 还可以使用"?1"的形式传递参数 */
	@Query("select u from User u where u.name=?1")
	User findUser2(String name);
}
