package com.cts.newsarticle.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.newsarticle.bean.Role;
import com.cts.newsarticle.bean.SignUpStatus;
import com.cts.newsarticle.bean.User;
import com.cts.newsarticle.repository.UserRepository;

@Service
public class UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	private UserRepository userRepository;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional
	public SignUpStatus saveUser(User user) {
		SignUpStatus signUpStatus = new SignUpStatus();
		Role role = new Role();
		role.setId(2);
		user.setRole(role);
		userRepository.save(user);
		signUpStatus.setSignupStatus(true);
		signUpStatus.setMessage("Successfully Signed Up");
		return signUpStatus;

	}	

	@Transactional
	public User getUser(String email) {
		LOGGER.info("Start");
		LOGGER.debug("UserId: {}", email);
		LOGGER.info("End");
		return userRepository.getUserByEmail(email);
	}

	@Transactional
	public User findAnalyst(String email) {
		LOGGER.info("START");

		User user = userRepository.getUserByEmail(email);
		if (user.getRole().getId() == 2) {
			LOGGER.info("END");
			return user;
		} else
			return null;

	}

	@Transactional
	public User saveAnalystStatus(String email) {
		User user = userRepository.getUserByEmail(email);
		LOGGER.info("email");
		if (user.getRole().getId() == 2) {
			if (user.isStatus()) {
				user.setStatus(false);
			} else {
				user.setStatus(true);
			}
			userRepository.save(user);

			return userRepository.getUserByEmail(email);
		}

		else
			return null;
	}

}
