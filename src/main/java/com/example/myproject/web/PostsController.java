package com.example.myproject.web;

import com.example.myproject.HttpUtils;
import com.example.myproject.service.PostsService;
import com.example.myproject.service.QuestionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class PostsController {

    private final PostsService postsService;
    private final QuestionsService questionsService;

    @GetMapping("/posts/save")
    public String postsSave() {
        return "/post/form";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable Long id, Model model) {

        model.addAttribute("posts", postsService.findById(id));
        model.addAttribute("questions", questionsService.findByPostId(id));

        return "/post/show";
    }


    @GetMapping("/posts/search")
    public String search(@RequestParam String keyword, Model model) {
        model.addAttribute("posts", postsService.searchPosts(keyword));
        return "/post/search";
    }

    @GetMapping("/posts/update/{id}")
    public String update(@PathVariable Long id, Model model, HttpSession session) {
        if(!HttpUtils.getUserFromSession(session).getId().equals(id)){
            return "redirect:/";
        }
        model.addAttribute("posts", postsService.findById(id));
        return "/post/updateForm";
    }
    @GetMapping("/posts/delete/{id}")
    public String delete(@PathVariable Long id, HttpSession session){
        if(!HttpUtils.getUserFromSession(session).getId().equals(id)){
            return "redirect:/";
        }
        postsService.delete(id);
        return "redirect:/";
    }
}
