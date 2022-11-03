package com.greyfolk99.todolist.controller;

import com.greyfolk99.todolist.model.network.request.UserRegisterRequest;
import com.greyfolk99.todolist.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/user/new")
    public String signUp(@ModelAttribute UserRegisterRequest request){
        userService.create(request);
        return "redirect:/";
    }
}
