package com.example.spbootjm2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.spbootjm2.domain.City;
import com.example.spbootjm2.mapper.CityMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.example.spbootjm2.mapper")
public class Spbootjm2ApplicationTests {

	@Autowired
	private CityMapper cityMapper;

	@Test
	public void test1() {
		City city = cityMapper.findByName("重庆");
		System.out.println(city);
	}

}
