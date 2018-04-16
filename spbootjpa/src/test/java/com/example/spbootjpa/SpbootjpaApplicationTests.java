package com.example.spbootjpa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.spbootjpa.domain.p.User;
import com.example.spbootjpa.domain.p.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpbootjpaApplicationTests {

	@Autowired
	private UserRepository userRepository;

	// @Before
	public void init() {
		userRepository.deleteAll();
	}

	@Test
	public void test1() {
		userRepository.save(new User("Jack", 20));
		userRepository.save(new User("Rose", 18));
		userRepository.save(new User("Zhangsan", 30));

		Assert.assertEquals(3, userRepository.findAll().size());
	}

	@Test
	public void test2() {
		Assert.assertEquals(20, userRepository.findByName("Jack").getAge().longValue());
	}

	@Test
	public void test3() {
		Assert.assertEquals("Rose", userRepository.findByNameAndAge("Rose", 18).getName());
	}

	@Test
	public void test4() {
		Assert.assertEquals("Zhangsan", userRepository.findUser("Zhangsan").getName());
	}

	@Test
	public void test5() {
		Assert.assertEquals("Zhangsan", userRepository.findUser2("Zhangsan").getName());
	}

}
