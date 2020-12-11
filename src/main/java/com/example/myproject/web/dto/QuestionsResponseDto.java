package com.example.myproject.web.dto;

import com.example.myproject.domain.questions.Questions;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class QuestionsResponseDto {
    private Long id;
    private Long postId;
    private String writer;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public QuestionsResponseDto(Questions questions){
        this.id = questions.getId();
        this.writer = questions.getWriter();
        this.content = questions.getContent();
        this.postId = questions.getPostId();
        this.createdDate = questions.getCreatedDate();
        this.modifiedDate = questions.getModifiedDate();
    }

}
