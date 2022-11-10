package com.greyfolk99.todolist.controller;

import com.greyfolk99.todolist.model.request.LoginRequest;
import com.greyfolk99.todolist.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Home/Login")
@RequiredArgsConstructor
public class LoginPageController{
    private final UserService userService;

    @GetMapping("/")
    String open(){
        return "login";
    }

    @GetMapping("/")
    ModelAndView login(@RequestBody LoginRequest request){
        ModelAndView mav = new ModelAndView();
        return userService.login(request) ?
                mav.addObject("message","success") :
                mav.addObject("message","failed");
    }
}