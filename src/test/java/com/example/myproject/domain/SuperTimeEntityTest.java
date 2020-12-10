package com.example.myproject.domain;

import com.example.myproject.domain.posts.Posts;
import com.example.myproject.domain.posts.PostsRepository;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class SuperTimeEntityTest extends TestCase {

    @Autowired
    private PostsRepository postsRepository;

    @Test
    public void 등록_수정_시간테스트() throws Exception{
        //given
        LocalDateTime now = LocalDateTime.of(2020, 12,11,0,0,0);

        Posts savePost = Posts.builder()
                .writer("테스트 사용자")
                .content("테스트 내용")
                .title("테스트 제목")
                .build();
        postsRepository.save(savePost);

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        System.out.println(">>>>>>>createDate = " + posts.getCreatedDate());
        System.out.println(">>>>>>>modifiedDate = " + posts.getModifiedDate());
        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);

        //when
        savePost.update("수정된 제목", "수정된 내용");
        postsList.clear();
        postsList = postsRepository.findAll();

        //then
        posts = postsList.get(0);
        System.out.println(">>>>>>>createDate = " + posts.getCreatedDate());
        System.out.println(">>>>>>>modifiedDate = " + posts.getModifiedDate());

        assertThat(posts.getModifiedDate()).isAfter(posts.getCreatedDate());


    }
}