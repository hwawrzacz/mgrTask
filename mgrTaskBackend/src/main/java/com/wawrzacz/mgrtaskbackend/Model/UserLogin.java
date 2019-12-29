package com.wawrzacz.mgrtaskbackend.Model;

import javax.persistence.*;

@Entity
@Table(name="usersLogins")
public class UserLogin {

    //region Fields
    @Id
    private String login;
    private String password;
    //endregion

    //region Getters and setters
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    //endregion

    //region Constructors
    public UserLogin() { }

    public UserLogin(UserRegister user) {
        this.login = user.getLogin();
        this.password = user.getPassword();
    }

    public UserLogin(String login, String password) {
        this.login = login;
        this.password = password;
    }
    //endregion
}



