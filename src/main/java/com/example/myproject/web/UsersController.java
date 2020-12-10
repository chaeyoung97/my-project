package com.example.myproject.web;

import com.example.myproject.HttpUtils;
import com.example.myproject.domain.users.Users;
import com.example.myproject.service.UsersService;
import com.example.myproject.web.dto.UsersSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class UsersController {
    private final UsersService usersService;

    @GetMapping("/signup")
    public String signup(){
        return "user/signup";
    }

    @PostMapping("/users/signup")
    public String signup(@RequestParam String userId, @RequestParam String password, @RequestParam String email){
        UsersSaveRequestDto usersSaveRequestDto = UsersSaveRequestDto.builder()
                .password(password)
                .email(email)
                .userId(userId)
                .build();
         usersService.save(usersSaveRequestDto);
         return "redirect:/";
    }

    @GetMapping("/login")
    public String login(){
        return "/user/login";
    }

    @PostMapping("/users/login")
    public String login(@RequestParam String userId, @RequestParam String password, HttpSession session){
        if(!usersService.availableLogin(userId,password)){
            return "redirect:/login";
        }
        Users users = usersService.findByUserId(userId);
        System.out.println(users.toString());
        session.setAttribute(HttpUtils.SESSION_USER, users);
        System.out.println("로그인 성공");
        System.out.println(session.getAttribute(HttpUtils.SESSION_USER).toString());
        return "redirect:/";
    }
    @GetMapping("/users/logout")
    public String logout(HttpSession session){
        session.removeAttribute(HttpUtils.SESSION_USER);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String updateForm(){
        return "/user/updateForm";
    }

    @PostMapping("/users/update")
    public String update(HttpSession session, @RequestParam String userId, @RequestParam String email){
        Long id = HttpUtils.getUserFromSession(session).getId();
        Users users =usersService.update(id, userId, email);

        session.removeAttribute(HttpUtils.SESSION_USER);
        session.setAttribute(HttpUtils.SESSION_USER, users);
        System.out.println(session.getAttribute(HttpUtils.SESSION_USER).toString());
        return "redirect:/";
    }
}
