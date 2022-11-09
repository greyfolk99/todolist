package com.greyfolk99.todolist.mapper.impl;

import com.greyfolk99.todolist.mapper.ContentMapper;
import com.greyfolk99.todolist.mapper.ToDoMapper;
import com.greyfolk99.todolist.model.entity.ToDo;
import com.greyfolk99.todolist.model.request.NewToDoRequest;
import com.greyfolk99.todolist.model.response.ToDoResponse;
import lombok.NoArgsConstructor;

import java.util.stream.Collectors;

@NoArgsConstructor
public class ToDoMapperImpl implements ToDoMapper {
    @Override
    public ToDo toCreate(NewToDoRequest request) {
        return ToDo.builder()
                .title(request.getTitle())
                .userId(request.getUserId())
                .toDoStatus(request.getToDoStatus())
                .priority(request.getPriority())
                .build();
    }
    @Override
    public ToDoResponse toResponse(ToDo toDo) {
        return ToDoResponse.builder()
                .toDoId(toDo.getToDoId())
                .title(toDo.getTitle())
                .contentResponses(toDo.getContents()
                        .stream().map(content->ContentMapper.INSTANCE.toResponse(content))
                        .collect(Collectors.toList()))
                .build();
    }
}
