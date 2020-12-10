package com.example.myproject.domain.users;

import com.example.myproject.domain.SuperTimeEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@ToString
@NoArgsConstructor
@Getter
@Entity
public class Users extends SuperTimeEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String userId;

    @JsonIgnore
    //@Getter(AccessLevel.NONE)
    private String password;

    @Column(nullable = false)
    private String email;

    @Builder
    public Users(String userId,String password, String email){
        this.userId = userId;
        this.password = password;
        this.email = email;
    }

    public void update(String userId, String email){
        this.userId= userId;
        this.email =email;
    }
}
