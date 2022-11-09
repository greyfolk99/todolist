package com.greyfolk99.todolist.service;

import com.greyfolk99.todolist.model.entity.ToDo;
import com.greyfolk99.todolist.model.request.NewToDoRequest;
import com.greyfolk99.todolist.model.request.UpdateToDoRequest;
import com.greyfolk99.todolist.model.response.ToDoResponse;

import java.util.List;

public interface ToDoService {
    ToDoResponse response(ToDo toDO);
    ToDoResponse createToDo(NewToDoRequest request);
    ToDoResponse updateToDo(UpdateToDoRequest request);
    List<ToDoResponse> selectAllToDoByUserId(Long id);
}
