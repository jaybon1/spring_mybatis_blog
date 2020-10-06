package com.jaybon.springblog.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jaybon.springblog.model.User;

@Repository
public interface UserRepository {

	public List<User> findAll();
	
	public User findByUsername(String username);
	
	public User findByUsernameAndPassword(User user);
	
	public void save(User user);
	
}
