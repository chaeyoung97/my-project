package com.example.myproject.web.dto;

import com.example.myproject.domain.users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UsersSaveRequestDto {
    String userId;
    String password;
    String email;

    @Builder
    public UsersSaveRequestDto(String userId, String password, String email){
        this.userId = userId;
        this.password = password;
        this.email = email;
    }

    public Users toEntity(){
        return Users.builder()
                .userId(userId)
                .password(password)
                .email(email)
                .build();
    }
}
