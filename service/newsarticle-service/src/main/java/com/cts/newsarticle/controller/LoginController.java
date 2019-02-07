package com.cts.newsarticle.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.newsarticle.bean.AuthenticationStatus;
import com.cts.newsarticle.bean.User;
import com.cts.newsarticle.service.UserService;

@RestController
public class LoginController extends NewsArticleController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	private UserService userService;

	//private JwtGenerator jwtGenerator;

	/*public LoginController(JwtGenerator jwtGenerator) {
		this.jwtGenerator = jwtGenerator;
	}
*/
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationStatus> authenticate(@RequestBody User user) {
		LOGGER.info("Start");

		LOGGER.debug("From request (user) : {}", user);

		String email = user.getEmail();
		LOGGER.debug("Value of email: {}", email);
		String password = user.getPassword();
		LOGGER.debug("Value of password: {} ", password);

		String actualPassword = "";
		String actualEmail = "";
		AuthenticationStatus status = new AuthenticationStatus();
		status.setAuthenticated(false);
		status.setAdmin(false);
		User actualUser = userService.getUser(email);

		LOGGER.debug("From request (actualUser) : {}", actualUser);
		if (actualUser != null) {
			actualPassword = actualUser.getPassword();
			if (email.equals("admin@gmail.com") && password.equals(actualPassword)) {
				//status.setToken(jwtGenerator.generate(actualUser));
				status.setUser(actualUser);
				status.setAdmin(true);
				status.setAuthenticated(true);

			} else {

				actualEmail = actualUser.getEmail();
				status.setUser(actualUser);
				status.setAuthenticated(actualEmail.equals(email));
				status.setAuthenticated(actualPassword.equals(password));
			}
		}
		LOGGER.debug("Value of actualPassword: {} ", actualPassword);
		LOGGER.debug("Value of actualPassword: {} ", actualEmail);
		LOGGER.debug("Value of status: {} ", status);
		LOGGER.info("End");
		return new ResponseEntity<AuthenticationStatus>(status, HttpStatus.OK);
	}

	@GetMapping("/analyst/{email}")
	public User findAnalystList(@PathVariable String email) {
		LOGGER.info(" START");
		User user = new User();
		user = userService.findAnalyst(email);
		LOGGER.debug("user : {} ", user);
		LOGGER.info("END");
		return user;

	}

	@GetMapping("/saveuser/{email}")
	public User saveAnalyst(@PathVariable String email) {
		LOGGER.info("email");
		User user = userService.saveAnalystStatus(email);
		return user;
	}
}
