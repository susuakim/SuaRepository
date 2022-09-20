package com.smhrd.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.smhrd.mapper")
@ComponentScan("com.smhrd.controller")
@SpringBootApplication
public class SpringBoot03Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot03Application.class, args);
	}

}
