package com.wawrzacz.mgrtaskbackend.Repositories;

import com.wawrzacz.mgrtaskbackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);
    User findByLogin(String login);
//    List<User> findAllByLoginOrFirstNameOrLastNameContaining(String name);
}
