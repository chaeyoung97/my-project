package com.example.myproject.service;

import com.example.myproject.domain.questions.QuestionRepository;
import com.example.myproject.web.dto.QuestionSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QuestionsService {
    private final QuestionRepository questionRepository;

    @Transactional
    public Long save(QuestionSaveRequestDto questionSaveRequestDto){
        return questionRepository.save(questionSaveRequestDto.toEntity()).getId();
    }
}
