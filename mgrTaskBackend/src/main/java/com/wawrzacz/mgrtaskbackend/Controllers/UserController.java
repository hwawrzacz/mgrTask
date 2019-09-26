package com.wawrzacz.mgrtaskbackend.Controllers;

import com.wawrzacz.mgrtaskbackend.Model.User;
import com.wawrzacz.mgrtaskbackend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    //region Fields
    String userUpdateStatus = "Empty";
    //endregion

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/hello")
    public String printHelloMessage() {
        System.out.println("Hello message");
        return "Hello";
    }

    @PostMapping("/add")
    public String addUser(@RequestBody User newUser) {
        if (!loginExists(newUser.getLogin())) {
            attemptSaveUser(newUser);
        }
        userUpdateStatus = "User already exists";
        return getUserUpdateStatus();
    }

    @GetMapping("/{login}")
    public User findUserByLogin(@PathVariable String login) {
        return userRepository.findByLogin(login);
    }

    @GetMapping("/id/{id}")
    public User findUserById(@PathVariable long id) {
        return userRepository.findById(id);
    }

//    @GetMapping("/search/{name}")
//    public List<User> findUserByName(@PathVariable String name){
//        return userRepository.findAllByLoginOrFirstNameOrLastNameContaining(name);
//    }

    private void attemptSaveUser(User newUser) {
        try {
            userRepository.save(newUser);
            userUpdateStatus = "User saved";
        } catch (Exception exc) {
            userUpdateStatus = "User could not be saved. Exception: " + exc.getMessage();
        }
    }

    private String getUserUpdateStatus() {
        return userUpdateStatus;
    }

    private boolean loginExists(String login) {
        return (userRepository.findByLogin(login) != null);
    }
}