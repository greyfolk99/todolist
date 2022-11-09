package com.greyfolk99.todolist.mapper.impl;

import com.greyfolk99.todolist.mapper.ToDoMapper;
import com.greyfolk99.todolist.mapper.UserMapper;
import com.greyfolk99.todolist.model.entity.User;
import com.greyfolk99.todolist.model.request.NewUserRequest;
import com.greyfolk99.todolist.model.response.UserResponse;
import lombok.NoArgsConstructor;

import java.util.stream.Collectors;

@NoArgsConstructor
public class UserMapperImpl implements UserMapper {
    @Override
    public User toRegister(NewUserRequest request) {
        return User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .nickname(request.getNickname())
                .build();
    }
    @Override
    public UserResponse toResponse(User user) {
        return UserResponse.builder()
                .userId(user.getUserId())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .toDoList(user.getToDoList()
                        .stream().map(toDo-> ToDoMapper.INSTANCE.toResponse(toDo))
                        .collect(Collectors.toList()))
                .build();
    }
}
