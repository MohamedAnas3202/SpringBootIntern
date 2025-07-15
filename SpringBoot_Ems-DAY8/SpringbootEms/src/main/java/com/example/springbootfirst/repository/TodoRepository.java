package com.example.springbootfirst.repository;

import com.example.springbootfirst.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    // Additional custom methods can be added here if needed
}
