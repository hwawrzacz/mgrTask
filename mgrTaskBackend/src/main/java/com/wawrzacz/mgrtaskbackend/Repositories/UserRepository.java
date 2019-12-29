package com.wawrzacz.mgrtaskbackend.Repositories;

import com.wawrzacz.mgrtaskbackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    User findByLogin(String login);
    List<User> findAllByFirstNameContaining(String name);
    List<User> findAllByLoginContaining(String name);
    List<User> findAllByLastNameContaining(String name);
}
