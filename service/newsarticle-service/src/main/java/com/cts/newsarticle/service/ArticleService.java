package com.cts.newsarticle.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.newsarticle.bean.Article;
import com.cts.newsarticle.bean.User;
import com.cts.newsarticle.repository.ArticleRepository;
import com.cts.newsarticle.repository.UserRepository;

@Service
public class ArticleService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleService.class);

	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public void saveArticle(User user) {
		LOGGER.info("Start");

		Article article = user.getArticle().get(0);
		String title = article.getTitle();
		Article actualArticle = articleRepository.findBytitle(title);

		LOGGER.debug("article  abcdes{}", article);
		User actualUser = userRepository.findById(user.getId());

		if (actualArticle == null) {
			actualArticle = articleRepository.save(article);

		}
		LOGGER.debug("id {}", actualArticle.getId());

		if (actualArticle.getId() != 0) {
			LOGGER.debug("Users favourite article  {}", actualUser.getArticle());
			actualUser.getArticle().add(actualArticle);
			userRepository.save(actualUser);
		}
		LOGGER.info("End");
	}

	@Transactional
	public User getUser(int id) {
		return userRepository.findById(id);

	}

	@Transactional
	public void deleteArticle(User user) {
		LOGGER.info("Start");
		User actualUser = userRepository.findById(user.getId());
		String title1 = user.getArticle().get(0).getTitle();
		List<Article> articles = actualUser.getArticle();
		LOGGER.debug("Users favourite article  {}", actualUser.getArticle());
		LOGGER.debug("User articles  {}", title1);
		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).getTitle().equals(title1)) {
				articles.remove(articles.get(i));
				actualUser.setArticle(articles);
			}
		}
		userRepository.save(actualUser);

	}
}
