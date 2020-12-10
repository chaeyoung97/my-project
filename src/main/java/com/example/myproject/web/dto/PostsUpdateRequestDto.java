package com.example.myproject.web.dto;

import com.example.myproject.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PostsUpdateRequestDto {
    private String title;
    private String content;
    private String writer;

    @Builder
    public PostsUpdateRequestDto(String title, String content, String writer){
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .build();
    }
}
