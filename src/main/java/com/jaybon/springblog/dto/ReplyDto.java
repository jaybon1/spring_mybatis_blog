package com.jaybon.springblog.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyDto {

	private int id;
	private int userId;
	private int postId;
	private String content;
	private Timestamp createDate;
	private String username;
	
}
