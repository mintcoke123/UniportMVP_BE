package com.example.uniport.api.quizzes.service;

import com.example.uniport.api.quizzes.dto.GetDailyQuizResponse;
import com.example.uniport.api.quizzes.dto.GetNewsQuizResponse;
import com.example.uniport.api.quizzes.dto.GetNewsQuizzesResponse;
import com.example.uniport.api.quizzes.dto.GetQuizAttemptsResponse;
import com.example.uniport.api.quizzes.dto.SubmitDailyQuizRequest;
import com.example.uniport.api.quizzes.dto.SubmitDailyQuizResponse;
import com.example.uniport.api.quizzes.dto.SubmitNewsQuizRequest;
import com.example.uniport.api.quizzes.dto.SubmitNewsQuizResponse;

public interface QuizzesService {
    GetNewsQuizzesResponse listNewsQuizzes(String cursor, Integer limit, String category);
    GetNewsQuizResponse getNewsQuiz(String quizId);
    SubmitNewsQuizResponse submitNewsQuiz(String quizId, SubmitNewsQuizRequest request, String idempotencyKey);

    GetDailyQuizResponse getDailyQuiz(String date);
    SubmitDailyQuizResponse submitDailyQuiz(String quizId, SubmitDailyQuizRequest request, String idempotencyKey);

    GetQuizAttemptsResponse listAttempts(String type, String cursor, Integer limit);
}

