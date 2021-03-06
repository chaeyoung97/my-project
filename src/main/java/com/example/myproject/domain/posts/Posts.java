package com.example.myproject.domain.posts;

import com.example.myproject.domain.SuperTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends SuperTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String writer;

    @Builder
    public Posts(String title, String content, String writer){
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
//@Getter
//@NoArgsConstructor//?? ??? ?? ?? ?? public Posts(){}
//@Entity // entitiy????? ?!!!?!!!! setter???? ???? ???1!!!!!!!!!!
//public class Posts {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(length = 500, nullable = false)
//    private String title;
//
//    @Column(columnDefinition = "TEXT", nullable = false)
//    private String content;
//
//    private String author;
//
//    @Builder
//    public Posts(String title, String content, String author){
//        this.title = title;
//        this.content = content;
//        this.author = author;
//    }
//}
