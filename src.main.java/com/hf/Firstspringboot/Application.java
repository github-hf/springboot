package com.hf.Firstspringboot;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
 

@SpringBootApplication
@ComponentScan(basePackages="com.hf.*")
@MapperScan("com.hf.*")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("启动完成。。。。。。。。。");
	}
}	
