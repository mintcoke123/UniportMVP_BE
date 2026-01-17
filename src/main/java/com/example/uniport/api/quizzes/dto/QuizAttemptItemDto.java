package com.example.uniport.api.quizzes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuizAttemptItemDto {
	private String quizType;
	private String quizId;
	private String date;
	private boolean isCorrect;
	private int awardedPoints;
}

