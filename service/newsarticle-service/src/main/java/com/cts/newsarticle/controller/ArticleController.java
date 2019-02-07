package com.cts.newsarticle.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.newsarticle.bean.User;
import com.cts.newsarticle.service.ArticleService;

@RestController
@RequestMapping("/rest")
public class ArticleController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);

	@Autowired
	private ArticleService articleService;

	@PostMapping("/saveArticle")
	public void saveArticle(@RequestBody User user) {
		LOGGER.info("Start");
		LOGGER.debug("user {}", user);
		articleService.saveArticle(user);
		LOGGER.info("End");

	}

	@GetMapping("/user/{id}")
	public User getUserDetails(@PathVariable("id") int id) {
		LOGGER.info("Start");
		LOGGER.debug("Id {}", id);
		User user = articleService.getUser(id);
		LOGGER.debug("user {}", user);
		LOGGER.info("END");
		return user;

	}

	@PostMapping("/delete")
	public void deleteArticle(@RequestBody User user) {
		LOGGER.info("Start");
		LOGGER.debug("user {}", user);
		articleService.deleteArticle(user);
	}
}
