package com.jaybon.springblog.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jaybon.springblog.model.Post;
import com.jaybon.springblog.model.User;

@Repository
public interface PostRepository {
	
	public List<Post> findAll();
	
	
	public List<Post> findAllDesc();
	
}
