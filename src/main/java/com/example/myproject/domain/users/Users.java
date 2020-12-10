package com.example.myproject.domain.users;

import com.example.myproject.domain.SuperTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Users extends SuperTimeEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Getter(AccessLevel.NONE)
    private String password;

    @Column(nullable = false)
    private String email;

    @Builder
    public Users(String userId,String password, String email){
        this.userId = userId;
        this.password = password;
        this.email = email;
    }
}
