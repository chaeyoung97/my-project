package com.example.myproject.domain.users;


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
public class UsersRepositoryTest {

    @Autowired
    UsersRepository usersRepository;

    @After
    public void cleanup(){
        usersRepository.deleteAll();
    }

    @Test
    public void 사용자등록_불러오기(){
        //given
        String userId = "spring";
        String password = "1111";
        String email = "111@email.com";

        usersRepository.save(Users.builder().userId(userId).password(password).email(email).build());

        //when
        List<Users> usersList = usersRepository.findAll();

        //then
        Users users = usersList.get(0);
        assertThat(users.getUserId()).isEqualTo(userId);
        assertThat(users.getEmail()).isEqualTo(email);

    }

}