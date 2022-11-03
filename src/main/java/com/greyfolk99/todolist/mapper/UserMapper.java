package com.greyfolk99.todolist.mapper;

import com.greyfolk99.todolist.model.entity.User;
import com.greyfolk99.todolist.model.network.request.UserRegisterRequest;
import com.greyfolk99.todolist.model.network.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User toRegister(UserRegisterRequest request);
    UserResponse response(User user);
}
