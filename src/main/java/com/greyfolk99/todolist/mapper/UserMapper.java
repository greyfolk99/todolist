package com.greyfolk99.todolist.mapper;

import com.greyfolk99.todolist.model.entity.User;
import com.greyfolk99.todolist.model.request.NewUserRequest;
import com.greyfolk99.todolist.model.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User toRegister(NewUserRequest request);
    UserResponse toResponse(User user);
}
