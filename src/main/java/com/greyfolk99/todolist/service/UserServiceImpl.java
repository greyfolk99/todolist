package com.greyfolk99.todolist.service;

import com.greyfolk99.todolist.model.entity.User;
import com.greyfolk99.todolist.model.network.request.UserRegisterRequest;
import com.greyfolk99.todolist.model.network.response.UserResponse;
import com.greyfolk99.todolist.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public UserResponse response(User user){
        return UserResponse.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .nickname(user.getNickname())
                .toDoList(user.getToDoList())
                .build();
    }
    public UserResponse create(UserRegisterRequest request) {
        return response(userRepository.save(
                User.builder()
                        .email(request.getEmail())
                        .password(request.getPassword())
                        .nickname(request.getNickname())
                        .phone(request.getPhone())
                        .build()));
    }
}