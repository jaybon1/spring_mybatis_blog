package com.jaybon.springblog.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jaybon.springblog.dto.ReplyDto;
import com.jaybon.springblog.model.Comment;

@Repository
public interface CommentRepository {
	
	public List<Comment> findAll();
	
	public List<ReplyDto> findAllByPostId(int id);

}
