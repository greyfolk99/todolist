package com.greyfolk99.todolist.repository;

import com.greyfolk99.todolist.model.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContentRepository extends JpaRepository<Content, Long> {
    int deleteByToDoId(Long id);
    List<Content> findByToDoId(Long toDoId);
}