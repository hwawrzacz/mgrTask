package com.wawrzacz.mgrtaskbackend.Repositories;

import com.wawrzacz.mgrtaskbackend.Model.Task;
import com.wawrzacz.mgrtaskbackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findById(long id);
    List<Task> findAllByNameContaining(String name);
    List<Task> findAllByCategory(String name);
    List<Task> findAllByAuthor(User user);
    List<Task> findAllByReceiver(User user);
}
