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
    String userUpdateStatus = "Empty";
    //endregion

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/test")
    public String test() {
            String json = "";
            User user = new User(1, "Andrzej", "Jak", "Ajak","sd");
            Task task = new Task("Hehe", "qqwe", "sd", new Date(12341234), new Date(234234123), user, user);

            ObjectMapper mapper = new ObjectMapper();

            try {
                json = mapper.writeValueAsString(task);
                System.out.println("JSON = " + json);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            return json;
        }

    @PostMapping(value = "/add")
    public String addUser(@RequestBody User newUser) {
        if (!loginExists(newUser.getLogin())) {
            attemptSaveUser(newUser);
        } else {
            userUpdateStatus = "User already exists";
        }

        return userUpdateStatus;
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

    private boolean loginExists(String login) {
        return (userRepository.findByLogin(login) != null);
    }
}