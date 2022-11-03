package com.greyfolk99.todolist.model.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String nickname;
    private String phone;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<ToDo> ToDoList;

    @Builder
    public User(Long id, String nickname, String password, String email, String phone) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
}