package com.example.myproject.service;

import com.example.myproject.domain.users.UsersRepository;
import com.example.myproject.web.dto.UsersSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Transactional
    public Long save(UsersSaveRequestDto usersSaveRequestDto){
        return usersRepository.save(usersSaveRequestDto.toEntity()).getId();
    }
}
