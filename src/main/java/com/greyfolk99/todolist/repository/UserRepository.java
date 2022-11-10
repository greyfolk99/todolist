package com.greyfolk99.todolist.repository;

import com.greyfolk99.todolist.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailEquals(String email);
    User findByEmailIs(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
}