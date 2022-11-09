package com.greyfolk99.todolist.service;

import com.greyfolk99.todolist.exception.NoDataFoundException;
import com.greyfolk99.todolist.mapper.ToDoMapper;
import com.greyfolk99.todolist.model.entity.ToDo;
import com.greyfolk99.todolist.model.request.NewToDoRequest;
import com.greyfolk99.todolist.model.request.UpdateToDoRequest;
import com.greyfolk99.todolist.model.response.ToDoResponse;
import com.greyfolk99.todolist.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ToDoServiceImpl implements ToDoService{
    private final Logger LOGGER = LogManager.getLogger(ToDoService.class);
    private final ToDoRepository toDoRepository;

    @Override
    public ToDoResponse response(ToDo toDo) {
        ToDoResponse toDoResponse = ToDoMapper.INSTANCE.toResponse(toDo);
        LOGGER.info("[response] Map toDo -> ToDoResponse : {}", toDoResponse.toString());
        return toDoResponse;
    }

    @Override
    public ToDoResponse createToDo(NewToDoRequest request) {
        ToDo toDo = ToDoMapper.INSTANCE.toCreate(request);
        LOGGER.info("[createToDo] Map NewToDoRequest -> toDo : {}", toDo.toString());
        toDo = toDoRepository.save(toDo);
        LOGGER.info("[createToDo] Save toDo -> toDo : {}", toDo.toString());
        return response(toDo);
    }

    @Override
    public ToDoResponse updateToDo(UpdateToDoRequest request) {
        ToDo toDo = toDoRepository.findById(request.getToDoId()).orElseThrow(()->new NoDataFoundException("Bad Request : todo id was not found"));
        LOGGER.info("[updateToDo] Find UpdateToDoRequest.id -> toDo : {}", toDo.toString());
        toDo.updateAll(request);
        LOGGER.info("[updateToDo] Update UpdateToDoRequest -> toDo : {}", toDo.toString());
        toDo = toDoRepository.save(toDo);
        LOGGER.info("[updateToDo] Save toDo -> toDo : {}", toDo.toString());
        return response(toDo);
    }

    @Override
    public List<ToDoResponse> selectAllToDoByUserId(Long id) {
        LOGGER.info("[selectAllToDoByUserId] id : {}", id);
        List<ToDo> toDoList = toDoRepository.findByUserId(id);
        LOGGER.info("[createUser] toDoList : {}", toDoList);
        return toDoList.stream().map(this::response).collect(Collectors.toList());
    }
}
