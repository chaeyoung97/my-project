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
    private Long postId;


    @Builder
    public QuestionSaveRequestDto(String writer, String content, Long postId){
        this.writer = writer;
        this.content = content;
        this.postId = postId;
    }

    public Questions toEntity(){
        return Questions.builder()
                .postId(postId)
                .writer(writer)
                .content(content)
                .build();
    }
}
