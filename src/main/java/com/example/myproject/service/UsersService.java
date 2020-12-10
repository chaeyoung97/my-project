package com.example.myproject.service;

import com.example.myproject.domain.users.Users;
import com.example.myproject.domain.users.UsersRepository;
import com.example.myproject.web.dto.UsersSaveRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
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

    @Transactional(readOnly = true)
    public boolean availableLogin(String userId, String password){
        if(usersRepository.findByUserId(userId).equals(null))
            return false;
        if(!usersRepository.findByUserId(userId).get().getPassword().equals(password))
            return false;
        return true;
    }
    @Transactional(readOnly = true)
    public Users findByUserId(String userId){
        return usersRepository.findByUserId(userId).get();
    }

    @Transactional
    public Users update(Long id, String userId, String email){
       Users users =  usersRepository.findById(id).get();
       users.update(userId, email);
       return users;
    }


}
