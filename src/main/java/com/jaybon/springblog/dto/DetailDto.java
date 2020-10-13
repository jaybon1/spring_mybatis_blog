package com.jaybon.springblog.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailDto {
	
	private BoardDto boardDto;
	private List<ReplyDto> replyDtos;
	
	
}
