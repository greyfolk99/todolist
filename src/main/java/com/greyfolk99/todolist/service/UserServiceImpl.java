package com.greyfolk99.todolist.service;

import com.greyfolk99.todolist.exception.NoDataFoundException;
import com.greyfolk99.todolist.mapper.UserMapper;
import com.greyfolk99.todolist.model.entity.User;
import com.greyfolk99.todolist.model.request.NewUserRequest;
import com.greyfolk99.todolist.model.response.UserResponse;
import com.greyfolk99.todolist.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final Logger LOGGER = LogManager.getLogger(UserService.class);
    private final UserRepository userRepository;

    @Override
    public UserResponse response(User user){
        return UserMapper.INSTANCE.toResponse(user);
    }
    @Override
    public UserResponse createUser(NewUserRequest request) {
        LOGGER.info("[createUser] NewUserRequest : {}", request.toString());
        User user = UserMapper.INSTANCE.toRegister(request);
        User newUser = userRepository.save(user);
        LOGGER.info("[createUser] user : {}", newUser);
        return response(newUser);
    }
    @Override
    public UserResponse selectUser(Long id){
        LOGGER.info("[selectUser] input id : {}", id);
        User user = userRepository.findById(id)
                .orElseThrow(()->new NoDataFoundException("failed to find a user"));
        LOGGER.info("[selectUser] user : {}", user);
        return response(user);
    }
    @Override
    public UserResponse searchUserByEmail(String email){
        LOGGER.info("[selectUser] input email : {}", email);
        User user = userRepository.findByEmail(email)
                .orElseThrow(()->new NoDataFoundException("failed to find a user"));
        LOGGER.info("[selectUser] user : {}", user);
        return response(user);
    }
    @Override
    public List<UserResponse> selectAllUsers(){
        List<User> userList = userRepository.findAll();
        LOGGER.info("[selectUser] userList : {}", userList);
        return userList.stream().map(this::response).collect(Collectors.toList());
    }
}