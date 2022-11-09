package com.greyfolk99.todolist.mapper;

import com.greyfolk99.todolist.model.entity.ToDo;
import com.greyfolk99.todolist.model.request.NewToDoRequest;
import com.greyfolk99.todolist.model.response.ToDoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ToDoMapper {
    ToDoMapper INSTANCE = Mappers.getMapper(ToDoMapper.class);
    ToDo toCreate(NewToDoRequest request);
    ToDoResponse toResponse(ToDo toDo);
}
