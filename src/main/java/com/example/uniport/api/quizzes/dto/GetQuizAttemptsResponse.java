package com.example.uniport.api.quizzes.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetQuizAttemptsResponse {
	private List<QuizAttemptItemDto> items;
	private String nextCursor;
}

