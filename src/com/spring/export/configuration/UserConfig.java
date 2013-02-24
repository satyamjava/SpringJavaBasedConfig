package com.spring.export.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.spring.export.domain.User;

@Configuration
@ComponentScan("com.spring.export.*")
public class UserConfig {
    
	@Bean
	public User userA() {
		User user = new User();
		user.setName("userA");
		return user;
	}
	@Bean
	public User userB() {
		User user = new User();
		user.setName("userB");
		return user;
	}
}
