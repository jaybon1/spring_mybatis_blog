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
public class BoardDto {

	private int id;
	private String title;
	private String content;
	private int userId;
	private Timestamp createDate;
	private String username;
	
}
