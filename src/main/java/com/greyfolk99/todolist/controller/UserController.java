package com.greyfolk99.todolist.controller;

import com.greyfolk99.todolist.model.request.NewUserRequest;
import com.greyfolk99.todolist.model.response.UserResponse;
import com.greyfolk99.todolist.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public String signUpPage(){
        return "createUserForm";
    }
    @PostMapping("/")
    public String signUp(@ModelAttribute NewUserRequest request){
        UserResponse userResponse = userService.createUser(request);
        return "redirect: ../";
    }
}
