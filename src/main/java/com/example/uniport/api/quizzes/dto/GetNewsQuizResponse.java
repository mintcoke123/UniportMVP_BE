package com.example.uniport.api.quizzes.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetNewsQuizResponse {
	private String id;
	private String title;
	private String question;
	private List<QuizChoiceDto> choices;
	private boolean explanationAvailable;
}

