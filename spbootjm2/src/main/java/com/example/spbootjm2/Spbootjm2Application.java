package com.example.spbootjm2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.spbootjm2.mapper") // 用于完成接口->XML文件的映射
public class Spbootjm2Application {

	public static void main(String[] args) {
		SpringApplication.run(Spbootjm2Application.class, args);
	}
}
