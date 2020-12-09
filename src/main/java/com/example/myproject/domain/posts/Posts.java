package com.example.myproject.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

    private String writer;

    @Builder
    public Posts(String title, String content, String writer){
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
//@Getter
//@NoArgsConstructor//기본 생성자 자동 추가 기능 public Posts(){}
//@Entity // entitiy클래스에는 절!!!대!!!! setter메소드를 생성하지 않는다1!!!!!!!!!!
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
