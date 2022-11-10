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
        private String password;
        @NotBlank
        private String passwordRe;
    }

