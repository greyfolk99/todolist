package com.greyfolk99.todolist.model.request;

import com.greyfolk99.todolist.model.enums.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public class LoginRequest {
        @NotBlank
        private String email;
        @NotBlank
        private String nickname;
        @NotBlank
        private String password;
        @NotBlank
        private Role role;

        @Builder
        public LoginRequest(String email, String nickname, String password, Role role) {
            this.email = email;
            this.nickname = nickname;
            this.password = password;
            this.role = role;
        }
    }

