package com.cts.newsarticle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.newsarticle.bean.Language;


@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {

}
