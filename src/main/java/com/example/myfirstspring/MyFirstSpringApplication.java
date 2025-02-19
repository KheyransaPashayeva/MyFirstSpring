package com.example.myfirstspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
public class MyFirstSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstSpringApplication.class, args);
	}

}
