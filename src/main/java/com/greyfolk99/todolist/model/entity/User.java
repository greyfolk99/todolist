package com.greyfolk99.todolist.model.entity;

import com.greyfolk99.todolist.model.enums.Role;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String email;
    private String password;
    private String nickname;
    private Role role;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<ToDo> ToDoList = new ArrayList<>();

    @Builder
    public User(Long userId, String nickname, String password, String email, Role role) {
        this.userId = userId;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public String getRoleValue() {
        return this.role.getValue();
    }
}