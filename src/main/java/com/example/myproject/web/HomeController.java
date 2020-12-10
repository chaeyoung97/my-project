package com.example.myproject.web;

import com.example.myproject.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final PostsService postsService;
    @GetMapping("")
    public String home(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "/home";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "/post/form";
    }
}
