package com.scs.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.scs")
@MapperScan("com.scs.mapper")
public class ScsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScsApplication.class, args);
	}

}
