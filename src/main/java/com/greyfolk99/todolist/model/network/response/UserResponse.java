package com.greyfolk99.todolist.model.network.response;

import com.greyfolk99.todolist.model.entity.ToDo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
public class UserResponse{
    private String email;
    private String password;
    private String nickname;
    private String phone;
    private List<ToDo> toDoList;
    @Builder
    public UserResponse(String email, String password, String nickname, String phone, List<ToDo> toDoList) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.phone = phone;
        this.toDoList = toDoList;
    }
}