package com.example.uniport.api.community.dto;

import java.util.List;
import com.example.uniport.api.common.dto.UserBrief;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetPostResponse {
	private String id;
	private String title;
	private String content;
	private UserBrief author;
	private String createdAt;
	private List<String> tags;
	private int comments;
}

