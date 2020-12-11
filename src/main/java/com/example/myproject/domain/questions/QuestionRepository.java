package com.example.myproject.domain.questions;

import com.example.myproject.web.dto.QuestionsResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository <Questions, Long> {
    public List<Questions> findByPostIdOrderByCreatedDateDesc(Long id);

}
