package com.example.Todoapp.repository;
import com.example.Todoapp.model.Todo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Todo,Long> {
}
