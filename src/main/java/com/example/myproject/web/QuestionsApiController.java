package com.example.myproject.web;

import com.example.myproject.service.QuestionsService;
import com.example.myproject.web.dto.QuestionSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/questions")
@RestController
public class QuestionsApiController {

    private final QuestionsService questionsService;

    @PostMapping("")
    public Long save(QuestionSaveRequestDto questionSaveRequestDto){
        return questionsService.save(questionSaveRequestDto);
    }
}
