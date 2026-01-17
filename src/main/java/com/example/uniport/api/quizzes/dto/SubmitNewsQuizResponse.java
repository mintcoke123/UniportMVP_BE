package com.example.uniport.api.quizzes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SubmitNewsQuizResponse {
	private boolean isCorrect;
	private int awardedPoints;
	private int totalPoints;
	private boolean showExplanation;
	private String explanation;
}

