package com.wawrzacz.mgrtaskbackend.Controllers;

import com.wawrzacz.mgrtaskbackend.Model.Task;
import com.wawrzacz.mgrtaskbackend.Model.UpdateStatus;
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
    UpdateStatus taskUpdateStatus = UpdateStatus.STATUS_NOT_SET;

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

    @GetMapping("/author/{login}")
    public List<Task> getTaskByAuthor(@PathVariable String login) {
        User user = userRepository.findByLogin(login);
        return taskRepository.findAllByAuthor(user);
    }

    @GetMapping("/receiver/{login}")
    public List<Task> getTaskByReceiver(@PathVariable String login) {
        User user = userRepository.findByLogin(login);
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
    public UpdateStatus addTask(@RequestBody Task newTask) {
        if (!taskExists(newTask.getId())) {
            attemptSaveTask(newTask);
        } else {
            taskUpdateStatus = UpdateStatus.ALREADY_EXISTS;
        }
        return taskUpdateStatus;
    }

    @PutMapping("/update")
    public UpdateStatus updateTask(@RequestBody Task task) {
        attemptSaveTask(task);
        return taskUpdateStatus;
    }

    @PutMapping("/delete")
    public UpdateStatus deleteTask(@RequestBody Task task) {
        taskRepository.delete(task);
        return taskUpdateStatus;
    }
    //endregion

    //region Base functions
    private void attemptSaveTask(Task task) {
        try{
            taskRepository.save(task);
            taskUpdateStatus = UpdateStatus.SAVE_OK;
        } catch (Exception exc) {
            taskUpdateStatus = UpdateStatus.SAVE_FAILED;
        }
    }

    private boolean taskExists(long id) {
        return taskRepository.findById(id) != null;
    }
    //endregion
}
