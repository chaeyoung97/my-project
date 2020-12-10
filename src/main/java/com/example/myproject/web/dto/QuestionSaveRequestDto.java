package com.example.myproject.web.dto;

import com.example.myproject.domain.questions.Questions;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class QuestionSaveRequestDto {
    private String writer;
    private String content;


    @Builder
    public QuestionSaveRequestDto(String writer, String content){
        this.writer = writer;
        this.content = content;
    }

    public Questions toEntity(){
        return Questions.builder()
                .writer(writer)
                .content(content)
                .build();
    }
}
