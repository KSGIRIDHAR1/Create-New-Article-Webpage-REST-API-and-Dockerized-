package com.cts.newsarticle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.newsarticle.bean.Article;

public interface ArticleRepository extends JpaRepository<Article, String> {
	Article findBytitle(String title);
	
}
