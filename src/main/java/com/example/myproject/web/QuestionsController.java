package com.example.myproject.web;

import com.example.myproject.HttpUtils;
import com.example.myproject.service.QuestionsService;
import com.example.myproject.web.dto.QuestionSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RequestMapping("/posts/{id}/questions")
@Controller
public class QuestionsController {
    private final QuestionsService questionsService;

    @PostMapping("")
    public String save(@PathVariable Long id, String contents, HttpSession session){
        questionsService.save(QuestionSaveRequestDto.builder()
                .content(contents)
                .postId(id)
                .writer(HttpUtils.getUserFromSession(session).getUserId())
                .build());
        return String.format("redirect:/posts/%d", id);
    }
    @GetMapping("/{qId}/delete")
    public String delete(@PathVariable Long id, @PathVariable Long qId, HttpSession session){
        if(!HttpUtils.getUserFromSession(session).getId().equals(questionsService.findById(id))){
            return "redirect:/";
        }
        questionsService.delete(qId);
        return String.format("redirect:/posts/%d", id);

    }
}
