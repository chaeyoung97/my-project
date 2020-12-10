package com.example.myproject.web;

import com.example.myproject.domain.users.Users;
import com.example.myproject.domain.users.UsersRepository;
import com.example.myproject.web.dto.QuestionSaveRequestDto;
import com.example.myproject.web.dto.UsersSaveRequestDto;
import junit.framework.TestCase;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //randomport로하면 내장톰캣을 사용하고, TestRestTemplate사용가능해짐
public class UsersApiControllerTest extends TestCase {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    UsersRepository usersRepository;

    @Test
    public void 회원가입() throws Exception{
        //given
        String userId = "테스트 아이디";
        String password = "1111";
        String email = "spring@test.com";

        UsersSaveRequestDto usersSaveRequestDto = UsersSaveRequestDto.builder()
                .userId(userId)
                .password(password)
                .email(email)
                .build();

        String url = "http://localhost:" + port + "/api/users/signup";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, usersSaveRequestDto, Long.class);

        //then
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseEntity.getBody()).isNotNull();
        Assertions.assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Users> usersList = usersRepository.findAll();
        Assertions.assertThat(usersList.get(0).getUserId()).isEqualTo(userId);
        Assertions.assertThat(usersList.get(0).getEmail()).isEqualTo(email);

    }
}