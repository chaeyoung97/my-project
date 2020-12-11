package com.example.myproject.web;

import com.example.myproject.HttpUtils;
import com.example.myproject.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final PostsService postsService;

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "/home";
    }
}

