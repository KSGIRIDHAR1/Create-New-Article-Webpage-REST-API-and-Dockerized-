package com.cts.newsarticle.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.newsarticle.bean.Language;
import com.cts.newsarticle.repository.LanguageRepository;

@Service
public class LanguageService {

	private static final Logger logger = LoggerFactory.getLogger(ArticleService.class);
	@Autowired
	private LanguageRepository languageRepository;

	@Transactional
	public List<Language> getLanguages(Language language) {
		logger.debug("Languages from database :{}", languageRepository.findAll());
		return languageRepository.findAll();
	}

}
