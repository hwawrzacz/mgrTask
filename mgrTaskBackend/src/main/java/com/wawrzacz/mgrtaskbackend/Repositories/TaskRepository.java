package com.wawrzacz.mgrtaskbackend.Repositories;

import com.wawrzacz.mgrtaskbackend.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findById(long id);
    List<Task> findAllByNameContaining(String name);
    List<Task> findAllByAuthorContaining(String userLogin);
}
