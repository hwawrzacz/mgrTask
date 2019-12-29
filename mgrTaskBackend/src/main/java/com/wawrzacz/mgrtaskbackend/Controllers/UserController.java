package com.wawrzacz.mgrtaskbackend.Controllers;

import com.wawrzacz.mgrtaskbackend.Model.UpdateStatus;
import com.wawrzacz.mgrtaskbackend.Model.User;
import com.wawrzacz.mgrtaskbackend.Model.UserLogin;
import com.wawrzacz.mgrtaskbackend.Model.UserRegister;
import com.wawrzacz.mgrtaskbackend.Repositories.UserLoginRepository;
import com.wawrzacz.mgrtaskbackend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    //region Fields
    private UpdateStatus userUpdateStatus = UpdateStatus.STATUS_NOT_SET;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserLoginRepository userLoginRepository;
    //endregion

    //region Get methods
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{login}")
    public User findUserByLogin(@PathVariable String login) {
        return userRepository.findByLogin(login);
    }

    @GetMapping("/search/{name}")
    public List<User> findUserByName(@PathVariable String name){
        return userRepository.findAllByFirstNameContaining(name);
    }

    @PostMapping("/login")
    public boolean logUserIn(@RequestBody UserLogin user){
        UserLogin gotUser = userLoginRepository.findByLogin(user.getLogin());
        String password = gotUser.getPassword();

        return (password.equals(user.getPassword()));
    }
    //endregion

    //region Add, update, delete methods
    @PostMapping("/add")
    public UpdateStatus addUser(@RequestBody UserRegister newUser) {
        if (!loginExists(newUser.getLogin())) {
            attemptSaveUser(newUser);
        } else {
            userUpdateStatus = UpdateStatus.ALREADY_EXISTS;
        }

        return userUpdateStatus;
    }

    @PutMapping("/update")
    public UpdateStatus updateUser(@RequestBody UserRegister updatedUser) {
        if (!loginExists(updatedUser.getLogin())) {
            attemptSaveUser(updatedUser);
        } else {
            userUpdateStatus = UpdateStatus.ALREADY_EXISTS;
        }
        return userUpdateStatus;
    }

    @DeleteMapping("/delete")
    public UpdateStatus deleteUser(@RequestBody UserRegister userToDelete) {
        if (loginExists(userToDelete.getLogin())) {
            attemptDeleteUser(userToDelete);
        } else {
            userUpdateStatus = UpdateStatus.NOT_EXISTS;
        }
        return userUpdateStatus;
    }

    private void attemptDeleteUser(UserRegister userToDelete) {
        try {
            User user = new User(userToDelete);
            UserLogin userLogin = new UserLogin(userToDelete);

            userRepository.delete(user);
            userLoginRepository.delete(userLogin);
            userUpdateStatus = UpdateStatus.DELETE_OK;
        } catch (Exception exc) {
            userUpdateStatus = UpdateStatus.DELETE_FAILED;
        }
    }
    //endregion

    //region Base functions
    private void attemptSaveUser(UserRegister newUser) {
        try {
            User user = new User(newUser);
            UserLogin userLogin = new UserLogin(newUser);

            userRepository.save(user);
            userLoginRepository.save(userLogin);
            userUpdateStatus = UpdateStatus.SAVE_OK;
        }
        catch (Exception exc) {
            userUpdateStatus = UpdateStatus.SAVE_FAILED;
        }
    }

    private boolean loginExists(String login) {
        return (userRepository.findByLogin(login) != null &&
                this.userLoginRepository.findByLogin(login) != null);
    }
    //endregion
}
