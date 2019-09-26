package com.wawrzacz.mgrtaskbackend.Controllers;

import com.wawrzacz.mgrtaskbackend.Model.Task;
import com.wawrzacz.mgrtaskbackend.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/tasks")
public class TaskController {

    //region Fields
    String taskUpdateStatus = "Empty";
    //endregion

    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/hello")
    public String showHelloMessage() {
        System.out.println("Hello!");
        return "Hello";
    }

    @GetMapping("/id/{id}")
    public Task getTaskById(@PathVariable long id) {
        return taskRepository.findById(id);
    }

    @GetMapping("/author/{id}")
    public List<Task> getTaskByAuthor(@PathVariable long id) {
        return taskRepository.findAllByAuthor(id);
    }

    @PostMapping("/add")
    public String addUser(@RequestBody Task task) {
        attemptSaveTask(task);
        return getTaskUpdateStatus();
    }

    private void attemptSaveTask(Task task) {
        try{
            taskRepository.save(task);
            taskUpdateStatus = "Task added";
        } catch (Exception exc) {
            taskUpdateStatus = "Task could not be saved. Exception: " + exc.getMessage();
        }
    }

    private String getTaskUpdateStatus() {
        return taskUpdateStatus;
    }
}
