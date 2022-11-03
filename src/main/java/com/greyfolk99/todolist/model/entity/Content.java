package com.greyfolk99.todolist.model.entity;

import com.greyfolk99.todolist.model.entity.BaseEntity;
import com.greyfolk99.todolist.model.enums.Priority;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Content extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer order;
    @Enumerated(EnumType.ORDINAL)
    private Priority priority;
    private String context;

    @ManyToOne
    ToDo toDo;
}