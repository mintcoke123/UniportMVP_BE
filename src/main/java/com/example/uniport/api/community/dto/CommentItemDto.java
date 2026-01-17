package com.example.uniport.api.community.dto;

import com.example.uniport.api.common.dto.UserBrief;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentItemDto {
	private String id;
	private String content;
	private UserBrief author;
	private String createdAt;
}

