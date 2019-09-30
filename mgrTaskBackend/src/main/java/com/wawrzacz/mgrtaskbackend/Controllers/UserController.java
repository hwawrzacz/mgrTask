package com.wawrzacz.mgrtaskbackend.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wawrzacz.mgrtaskbackend.Model.Task;
import com.wawrzacz.mgrtaskbackend.Model.User;
import com.wawrzacz.mgrtaskbackend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    //region Fields

    private String userUpdateStatus = "Empty";

    @Autowired
    private UserRepository userRepository;
    //endregion

    //region Get methods

    @GetMapping(value = "/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{login}")
    public User findUserByLogin(@PathVariable String login) {
        return userRepository.findByLogin(login);
    }

    @GetMapping("/id/{id}")
    public User findUserById(@PathVariable long id) {
        return userRepository.findById(id);
    }

    @GetMapping("/search/{name}")
    public List<User> findUserByName(@PathVariable String name){
        return userRepository.findAllByFirstNameContaining(name);
    }
    //endregion

    //region Add, update, delete methods

    @PostMapping("/add")
    public String addUser(@RequestBody User newUser) {
        if (!loginExists(newUser.getLogin())) {
            attemptSaveUser(newUser);
        } else {
            userUpdateStatus = "User already exists";
        }

        return userUpdateStatus;
    }

    @PutMapping("/update")
    public String updateUser(@RequestBody User updatedUser) {
        attemptSaveUser(updatedUser);
        return userUpdateStatus;
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestBody User sadUser) {
        attemptDeleteUser(sadUser);
        return userUpdateStatus;
    }

    private void attemptDeleteUser(User sadUser) {
        try {
            userRepository.delete(sadUser);
            userUpdateStatus = "User deleted";
        } catch (Exception exc) {
            userUpdateStatus = "User could not be deleted. Exception: " + exc.getMessage();
        }
    }
    //endregion

    //region IDK how to call those functions. Helpers, maybe...
    private void attemptSaveUser(User newUser) {
        try {
            userRepository.save(newUser);
            userUpdateStatus = "User saved";
        } catch (Exception exc) {
            userUpdateStatus = "User could not be saved. Exception: " + exc.getMessage();
        }
    }

    private boolean loginExists(String login) {
        return (userRepository.findByLogin(login) != null);
    }
    //endregion
}