package com.greyfolk99.todolist.model.response;

import com.greyfolk99.todolist.model.enums.Priority;
import com.greyfolk99.todolist.model.enums.ToDoStatus;
import lombok.*;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ToDoResponse{
    private Long toDoId;
    private String title;
    @Nullable
    private Priority priority;
    @Nullable
    private ToDoStatus toDoStatus;
    private List<ContentResponse> contentResponses;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    @Builder
    public ToDoResponse(Long toDoId, String title, Priority priority, ToDoStatus toDoStatus, List<ContentResponse> contentResponses) {
        this.toDoId = toDoId;
        this.title = title;
        this.priority = priority;
        this.toDoStatus = toDoStatus;
        this.contentResponses = contentResponses;
    }
}