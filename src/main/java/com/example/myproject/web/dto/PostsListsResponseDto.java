package com.example.myproject.web.dto;

import com.example.myproject.domain.posts.Posts;
import lombok.Getter;

import java.security.PrivateKey;
import java.time.LocalDateTime;

@Getter
public class PostsListsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime modifiedDate;
    private LocalDateTime createdDate;

    public PostsListsResponseDto(Posts posts) {
        this.id = posts.getId();
        this.title = posts.getTitle();
        this.content = posts.getContent();
        this.writer = posts.getWriter();
        this.modifiedDate = posts.getModifiedDate();
        this.createdDate = posts.getCreatedDate();
    }
}

