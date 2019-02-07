package com.cts.newsarticle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.newsarticle.bean.User;

public interface UserRepository extends JpaRepository<User, String> {

	public User getUserByEmail(String email);
	public User findById(int id);
}
