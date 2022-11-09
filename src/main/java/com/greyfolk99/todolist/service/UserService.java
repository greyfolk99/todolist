package com.greyfolk99.todolist.service;

import com.greyfolk99.todolist.model.entity.User;
import com.greyfolk99.todolist.model.request.NewUserRequest;
import com.greyfolk99.todolist.model.response.UserResponse;

import java.util.List;


public interface UserService{
    UserResponse response(User user);
    UserResponse createUser(NewUserRequest request);
    UserResponse selectUser(Long id);
    UserResponse searchUserByEmail(String email);
    List<UserResponse> selectAllUsers();
}
