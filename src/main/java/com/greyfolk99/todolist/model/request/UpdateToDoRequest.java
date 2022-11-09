package com.greyfolk99.todolist.model.request;

import com.greyfolk99.todolist.model.enums.Priority;
import com.greyfolk99.todolist.model.enums.ToDoStatus;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdateToDoRequest {
    @NotBlank
    private Long toDoId;
    @NotBlank
    private String title;
    private Priority priority;
    private ToDoStatus toDoStatus;

    @Builder
    public UpdateToDoRequest(Long toDoId, String title, Priority priority, ToDoStatus toDoStatus) {
        this.toDoId = toDoId;
        this.title = title;
        this.priority = priority;
        this.toDoStatus = toDoStatus;
    }
}
