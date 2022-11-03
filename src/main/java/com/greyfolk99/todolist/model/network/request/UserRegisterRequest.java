package com.greyfolk99.todolist.model.network.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserRegisterRequest {
    private String email;
    private String nickname;
    private String password;
    private String phone;

    @Builder
    public UserRegisterRequest(String email, String nickname, String password, String phone) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.phone = phone;
    }
}