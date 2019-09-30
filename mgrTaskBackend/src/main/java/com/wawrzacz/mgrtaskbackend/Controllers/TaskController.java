package com.wawrzacz.mgrtaskbackend.Controllers;

import com.wawrzacz.mgrtaskbackend.Model.Task;
import com.wawrzacz.mgrtaskbackend.Model.User;
import com.wawrzacz.mgrtaskbackend.Repositories.TaskRepository;
import com.wawrzacz.mgrtaskbackend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/tasks")
public class TaskController {

    //region Fields
    String taskUpdateStatus = "Empty";

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;
    //endregion

    //region Get methods
    @GetMapping("/all")
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/id/{id}")
    public Task getTaskById(@PathVariable long id) {
        return taskRepository.findById(id);
    }

    @GetMapping("/author/{id}")
    public List<Task> getTaskByAuthor(@PathVariable long id) {
        User user = userRepository.findById(id);
        return taskRepository.findAllByAuthor(user);
    }

    @GetMapping("/receiver/{id}")
    public List<Task> getTaskByReceiver(@PathVariable long id) {
        User user = userRepository.findById(id);
        return taskRepository.findAllByReceiver(user);
    }

    @GetMapping("/cathegory/{name}")
    public List<Task> getTaskByCathegory(@PathVariable String name) {
        return taskRepository.findAllByCategory(name);
    }

    @GetMapping("/name/{name}")
    public List<Task> getTaskByName(@PathVariable String name) {
        return taskRepository.findAllByNameContaining(name);
    }
    //endregion

    //region Add, update, delete methods
    @PostMapping("/add")
    public String addUser(@RequestBody Task task) {
        attemptSaveTask(task);
        return taskUpdateStatus;
    }

    @PutMapping("/update")
    public String updateUser(@RequestBody Task task) {
        attemptSaveTask(task);
        return taskUpdateStatus;
    }
    //endregion

    //region Base functions
    private void attemptSaveTask(Task task) {
        try{
            taskRepository.save(task);
            taskUpdateStatus = "Task added";
        } catch (Exception exc) {
            taskUpdateStatus = "Task could not be saved. Exception: " + exc.getMessage();
        }
    }
    //endregion
}