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
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/hello")
    public String printHelloMessage() {
        System.out.println("Hello message");
        return "Hello";
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User newUser) {
        if (!loginExists(newUser.getLogin())) {
            saveUser(newUser);
        }
        System.out.println("User already exists");
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

    private void saveUser(User newUser) {
        try {
            userRepository.save(newUser);
            System.out.println("User saved");
        } catch (Exception exc) {
            System.out.println("User cannot be saved. Exception: " + exc.getMessage());
        }
    }

    private boolean loginExists(String login) {
        return (userRepository.findByLogin(login) != null);
    }
}