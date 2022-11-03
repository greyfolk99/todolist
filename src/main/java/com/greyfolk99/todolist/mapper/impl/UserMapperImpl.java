package com.greyfolk99.todolist.mapper.impl;

import com.greyfolk99.todolist.mapper.UserMapper;
import com.greyfolk99.todolist.model.entity.User;
import com.greyfolk99.todolist.model.network.request.UserRegisterRequest;
import com.greyfolk99.todolist.model.network.response.UserResponse;
import org.mapstruct.factory.Mappers;

public class UserMapperImpl implements UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    @Override
    public User toRegister(UserRegisterRequest request) {
        if (request == null) return null;
        return User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .nickname(request.getNickname())
                .phone(request.getPhone())
                .build();
    }

    @Override
    public UserResponse response(User user) {
        return UserResponse.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .nickname(user.getNickname())
                .toDoList(user.getToDoList())
                .build();
    }
}
