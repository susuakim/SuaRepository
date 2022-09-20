package com.smhrd.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.smhrd.mapper") // mapper 어노테이션을 찾아서 bean으로 만들기 위한 스캔
@ComponentScan("com.smhrd.controller")

@SpringBootApplication
public class SpringBoot02Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot02Application.class, args);
	}

}
