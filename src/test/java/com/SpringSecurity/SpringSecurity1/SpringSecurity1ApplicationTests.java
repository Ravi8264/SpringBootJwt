package com.SpringSecurity.SpringSecurity1;

import com.SpringSecurity.SpringSecurity1.entities.User;
import com.SpringSecurity.SpringSecurity1.services.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringSecurity1ApplicationTests {

	@Autowired
	private JwtService jwtService;

	@Test
	void contextLoads() {
		User user;
		user = new User(1L,"ravicse.gmail.com","1234","ravi");

		String token= jwtService.generateToken(user);

		System.out.println(token);

		Long id= jwtService.getUserIdFromToken(token);

		System.out.println(id);
	}

}
