package com.example.uniport.api.quizzes.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NewsQuizListItemDto {
	private String id;
	private String title;
	private String thumbnailUrl;
	private List<String> tags;
	private String createdAt;
}

