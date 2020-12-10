package com.example.myproject.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PostsRepositoryTest{

    @Autowired PostsRepository postsRepository;

    @After
    public void cleanup(){
        postsRepository.deleteAll();    //단위 테스트가 끝날 때마다 수행되서 db에 값이 쌓이는 것을 방지
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트 제목";
        String content = "테스트 내용";
        String writer = "테스트 사용자";
        postsRepository.save(Posts.builder().title(title).content(content).writer(writer).build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
        assertThat(posts.getWriter()).isEqualTo(writer);
    }
}
