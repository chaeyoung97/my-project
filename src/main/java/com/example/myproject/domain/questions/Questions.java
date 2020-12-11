package com.example.myproject.domain.questions;

import com.example.myproject.domain.SuperTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Questions extends SuperTimeEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @JoinColumn(foreignKey = @ForeignKey(name = "fk_questions_posts"))
    @Column(nullable = false)
    private Long postId;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false, length = 500)
    private String content;

    @Builder
    public Questions(String writer, String content,Long postId){
        this.postId = postId;
        this.writer = writer;
        this.content = content;
    }
}
