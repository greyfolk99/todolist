package com.greyfolk99.todolist.service;

import com.greyfolk99.todolist.exception.NoDataFoundException;
import com.greyfolk99.todolist.mapper.UserMapper;
import com.greyfolk99.todolist.model.entity.User;
import com.greyfolk99.todolist.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userServiceImpl;
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;

    User mockUser() {
        return userRepository.save(User.builder()
                .id(1L).email("hj9284@gmail.com").password("1234")
                .nickname("서희정").phone("010-9219-8699")
                .build());
    }
    @Test
    void response () {
    }

    @Test
    void create () {

    }

    @Test
    void selectOne () {

    }

    @Test
    @Transactional
    void searchByEmail () {
        assertDoesNotThrow(()->userRepository.findByEmail("shj9284@gmail.com").get(),"findByEmail Not working");
        assertNotNull(userRepository.findByEmailIs("shj9284@gmail.com"));
        assertDoesNotThrow(()->userRepository.findByEmailEquals("shj9284@gmail.com").get());

    }

    @Test
    void selectAll () {

    }
}