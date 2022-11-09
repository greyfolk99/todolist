package com.greyfolk99.todolist.repository;

import com.greyfolk99.todolist.model.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentRepository extends JpaRepository<Content, Long> {
    int deleteByToDoId(Long id);
}