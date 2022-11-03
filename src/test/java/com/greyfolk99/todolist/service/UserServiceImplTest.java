package com.greyfolk99.todolist.service;

import com.greyfolk99.todolist.mapper.UserMapper;
import com.greyfolk99.todolist.model.entity.User;
import com.greyfolk99.todolist.model.network.request.UserRegisterRequest;
import com.greyfolk99.todolist.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImplTest {
    @Autowired
    UserRepository userRepository;

    @Test
    @Transactional
    void save(){
        userRepository.save(User.builder()
                        .id(1L)
                .email("shj9284@gmail.com")
                .password("1234")
                .nickname("서희정")
                .phone("010-9219-8699")
                .build());
    }
}