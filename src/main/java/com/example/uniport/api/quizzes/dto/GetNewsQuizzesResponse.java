package com.example.uniport.api.quizzes.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetNewsQuizzesResponse {
	private List<NewsQuizListItemDto> items;
	private String nextCursor;
}

