package com.example.spbootjm;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.spbootjm.domain.User;
import com.example.spbootjm.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpbootjmApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void test1() {
		userMapper.insert("Rose", 18);
		User u = userMapper.findByName("Rose");

		Assert.assertEquals(18, u.getAge().intValue());
	}

}
