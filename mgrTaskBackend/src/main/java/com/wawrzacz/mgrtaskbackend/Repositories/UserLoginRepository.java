package com.wawrzacz.mgrtaskbackend.Repositories;

import com.wawrzacz.mgrtaskbackend.Model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserLoginRepository extends JpaRepository<UserLogin, String> {
    UserLogin findByLogin(String login);
}
