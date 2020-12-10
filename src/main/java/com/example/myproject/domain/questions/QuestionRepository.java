package com.example.myproject.domain.questions;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository <Questions, Long> {
}
