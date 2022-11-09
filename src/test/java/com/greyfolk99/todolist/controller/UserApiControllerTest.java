package com.greyfolk99.todolist.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greyfolk99.todolist.model.request.NewUserRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = UserController.class)
@ExtendWith(SpringExtension.class)
public class UserApiControllerTest{
    @MockBean
    private UserController userController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void postNewUserTest() throws Exception{
        NewUserRequest request = NewUserRequest.builder()
                .email("shj9284@gmail.com")
                .password("1234")
                .nickname("서희정")
                .phone("010-9219-8699")
                .build();
        String json = new ObjectMapper().writeValueAsString(request);
        System.out.println(json);
        mockMvc.perform(
                    MockMvcRequestBuilders
                    .post("http://localhost.8080/api/user")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


}
