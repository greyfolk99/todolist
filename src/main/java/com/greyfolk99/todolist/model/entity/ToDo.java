package com.greyfolk99.todolist.model.entity;

import com.greyfolk99.todolist.model.enums.Status;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ToDo extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private User user;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "toDo")
    private List<Content> contents;
}