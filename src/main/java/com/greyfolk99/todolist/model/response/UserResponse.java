package com.greyfolk99.todolist.model.response;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class UserResponse{
    private Long userId;
    private String email;
    private String nickname;
    private List<ToDoResponse> toDoList;
    @Builder
    public UserResponse(Long userId, String email, String nickname, List<ToDoResponse> toDoList) {
        this.userId = userId;
        this.email = email;
        this.nickname = nickname;
        this.toDoList = toDoList;
    }
}