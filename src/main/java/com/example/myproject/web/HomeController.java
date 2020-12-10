package com.example.myproject.web;

import com.example.myproject.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final PostsService postsService;

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "/home";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "/post/form";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("posts", postsService.findById(id));
        return "/post/show";
    }


    @GetMapping("/posts/search")
    public String search(@RequestParam String keyword, Model model) {
        model.addAttribute("posts", postsService.searchPosts(keyword));
        return "/post/search";
    }

    @GetMapping("/posts/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("posts", postsService.findById(id));
        return "/post/updateForm";
    }
}

