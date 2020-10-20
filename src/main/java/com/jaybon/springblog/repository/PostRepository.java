package com.jaybon.springblog.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jaybon.springblog.dto.BoardDto;
import com.jaybon.springblog.model.Post;
import com.jaybon.springblog.model.User;

@Repository
public interface PostRepository {
	
	public List<Post> findAll();
	
	public List<Post> findAllDesc();
	
	public BoardDto findById(int id);
	
	public void save(Post post);
	
	public int delete(int id);
	
	public int update(Post post);
	
}
