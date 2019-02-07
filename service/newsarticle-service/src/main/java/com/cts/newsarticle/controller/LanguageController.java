package com.cts.newsarticle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.newsarticle.bean.Language;
import com.cts.newsarticle.service.LanguageService;

@RestController
public class LanguageController {

	@Autowired
	private LanguageService languageservice;

	@GetMapping("/getLanguages")
	public List<Language> getLanguages(Language language) {
		return languageservice.getLanguages(language);
	}

}
