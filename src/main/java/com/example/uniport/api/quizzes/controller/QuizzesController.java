package com.example.uniport.api.quizzes.controller;

import com.example.uniport.api.common.dto.CursorPageParams;
import com.example.uniport.api.quizzes.dto.GetDailyQuizResponse;
import com.example.uniport.api.quizzes.dto.GetNewsQuizResponse;
import com.example.uniport.api.quizzes.dto.GetNewsQuizzesResponse;
import com.example.uniport.api.quizzes.dto.GetQuizAttemptsResponse;
import com.example.uniport.api.quizzes.dto.SubmitDailyQuizRequest;
import com.example.uniport.api.quizzes.dto.SubmitDailyQuizResponse;
import com.example.uniport.api.quizzes.dto.SubmitNewsQuizRequest;
import com.example.uniport.api.quizzes.dto.SubmitNewsQuizResponse;
import com.example.uniport.api.quizzes.service.QuizzesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class QuizzesController {

    private final QuizzesService quizzesService;

    @GetMapping("/quizzes/news")
    public GetNewsQuizzesResponse listNews(@ModelAttribute CursorPageParams page,
                                           @RequestParam(required = false) String category) {
        return quizzesService.listNewsQuizzes(page.getCursor(), page.getLimit(), category);
    }

    @GetMapping("/quizzes/news/{id}")
    public GetNewsQuizResponse getNewsQuiz(@PathVariable String id) {
        return quizzesService.getNewsQuiz(id);
    }

    @PostMapping("/quizzes/news/{id}/submit")
    public SubmitNewsQuizResponse submitNews(@PathVariable String id,
                                             @RequestBody SubmitNewsQuizRequest request,
                                             @RequestHeader(name = "Idempotency-Key", required = false) String idempotencyKey) {
        return quizzesService.submitNewsQuiz(id, request, idempotencyKey);
    }

    @GetMapping("/quizzes/daily")
    public GetDailyQuizResponse getDaily(@RequestParam(required = false) String date) {
        return quizzesService.getDailyQuiz(date);
    }

    @PostMapping("/quizzes/daily/{id}/submit")
    public SubmitDailyQuizResponse submitDaily(@PathVariable String id,
                                               @RequestBody SubmitDailyQuizRequest request,
                                               @RequestHeader(name = "Idempotency-Key", required = false) String idempotencyKey) {
        return quizzesService.submitDailyQuiz(id, request, idempotencyKey);
    }

    @GetMapping("/quizzes/attempts")
    public GetQuizAttemptsResponse listAttempts(@ModelAttribute CursorPageParams page,
                                                @RequestParam(required = false) String type) {
        return quizzesService.listAttempts(type, page.getCursor(), page.getLimit());
    }
}

