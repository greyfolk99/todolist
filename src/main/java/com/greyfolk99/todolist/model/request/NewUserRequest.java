package com.greyfolk99.todolist.model.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NewUserRequest {
    @NotBlank
    private String email;
    @NotBlank
    private String nickname;
    @NotBlank
    private String password;
    @Builder
    public NewUserRequest(String email, String nickname, String password, String phone) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }
}