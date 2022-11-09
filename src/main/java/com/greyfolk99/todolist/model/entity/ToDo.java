package com.greyfolk99.todolist.model.entity;

import com.greyfolk99.todolist.model.enums.Priority;
import com.greyfolk99.todolist.model.enums.ToDoStatus;
import com.greyfolk99.todolist.model.request.UpdateToDoRequest;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ToDo extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long toDoId;
    private String title;
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = true)
    private Priority priority;
    @Enumerated(EnumType.STRING)
    @Column(nullable = true, name = "status")
    private ToDoStatus toDoStatus;
    @Column(name = "user_id")
    private Long userId;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
    @OneToMany(mappedBy = "toDo")
    @ToString.Exclude
    private List<Content> contents = new ArrayList<>();

    @Builder
    public ToDo(Long toDoId, String title, Priority priority, ToDoStatus toDoStatus, Long userId, User user, List<Content> contents) {
        this.toDoId = toDoId;
        this.title = title;
        this.priority = priority;
        this.toDoStatus = toDoStatus;
        this.user = user;
        this.userId = userId;
        this.contents = contents;
    }
    public void updateAll(UpdateToDoRequest request){
        this.title = request.getTitle(); this.priority = request.getPriority(); this.toDoStatus = request.getToDoStatus();
    }
}