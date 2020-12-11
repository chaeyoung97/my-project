package com.example.myproject.service;

import com.example.myproject.domain.questions.QuestionRepository;
import com.example.myproject.domain.questions.Questions;
import com.example.myproject.web.dto.PostsListsResponseDto;
import com.example.myproject.web.dto.QuestionSaveRequestDto;
import com.example.myproject.web.dto.QuestionsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QuestionsService {
    private final QuestionRepository questionRepository;

    @Transactional
    public Long save(QuestionSaveRequestDto questionSaveRequestDto){
        return questionRepository.save(questionSaveRequestDto.toEntity()).getId();
    }

    @Transactional
    public void delete(Long id){
         questionRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Long findById(Long id){
        return questionRepository.findById(id).get().getId();
    }

    @Transactional(readOnly = true)
    public List<QuestionsResponseDto> findByPostId(Long id){
        return questionRepository.findByPostIdOrderByCreatedDateDesc(id).stream()
                .map(questions -> new QuestionsResponseDto(questions))
                .collect(Collectors.toList());
    }
}
