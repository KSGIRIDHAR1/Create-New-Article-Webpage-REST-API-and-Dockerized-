package com.cts.newsarticle.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.newsarticle.bean.SignUpStatus;
import com.cts.newsarticle.bean.User;
import com.cts.newsarticle.service.UserService;

@RestController
public class SignUpController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/save")
	public SignUpStatus signUp(@RequestBody User user) {
		LOGGER.info("Start");
		SignUpStatus signupStatus = userService.saveUser(user);
		LOGGER.debug("SignupStatus :{}", signupStatus);
		LOGGER.info("End");
		return signupStatus;
	}
}
