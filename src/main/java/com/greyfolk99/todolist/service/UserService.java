package com.greyfolk99.todolist.service;

import com.greyfolk99.todolist.model.network.request.UserRegisterRequest;
import com.greyfolk99.todolist.model.network.response.UserResponse;
import org.springframework.stereotype.Service;


public interface UserService{
    UserResponse create(UserRegisterRequest request);
}
