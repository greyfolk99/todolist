package com.greyfolk99.todolist.repository;

import com.greyfolk99.todolist.model.entity.ToDo;
import com.greyfolk99.todolist.model.enums.ToDoStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    List<ToDo> findByUserId(Long userId);
    Optional<ToDo> findByToDoStatus(ToDoStatus status);
}