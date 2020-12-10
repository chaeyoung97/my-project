package com.example.myproject.web;

import com.example.myproject.service.UsersService;
import com.example.myproject.web.dto.UsersSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/users")
@RestController
public class UsersApiController {
    private final UsersService usersService;

    @PostMapping("/login")
    public Long login(@RequestBody UsersSaveRequestDto usersSaveRequestDto){
        return usersService.save(usersSaveRequestDto);
    }
}
