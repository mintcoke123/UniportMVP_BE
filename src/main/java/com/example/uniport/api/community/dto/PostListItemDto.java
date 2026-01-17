package com.example.uniport.api.community.dto;

import com.example.uniport.api.common.dto.UserBrief;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostListItemDto {
	private String id;
	private String title;
	private String excerpt;
	private UserBrief author;
	private String createdAt;
	private int commentCount;
}

