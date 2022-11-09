package com.greyfolk99.todolist.repository;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@WebAppConfiguration
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    /*
        Optional<User> findByEmail(String email);
        Optional<User> findByEmailEquals(String email);
        User findByEmailIs(String email);
     */
    @Test
    @Transactional
    void findByEmail() {
        assertDoesNotThrow(()->userRepository.findByEmail("shj9284@gmail.com").get(),"findByEmail Not working");
    }

    @Test
    @Transactional
    void findByEmailEquals() {
        assertDoesNotThrow(()->userRepository.findByEmailEquals("shj9284@gmail.com").get(), "findByEmailEquals not working");
    }

    @Test
    @Transactional
    void findByEmailIs() {
        assertNotNull(userRepository.findByEmailIs("shj9284@gmail.com"),"findByEmailIs not working");
    }
}