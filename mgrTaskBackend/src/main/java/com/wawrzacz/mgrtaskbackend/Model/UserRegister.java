package com.wawrzacz.mgrtaskbackend.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.List;

public class UserRegister {

    //region Fields
    private String login;
    private String firstName;
    private String lastName;
    private String password;
    //endregion

    //region Getters and setters
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName){ this.lastName = lastName; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    //endregion

    //region Constructors
    public UserRegister() { }

    public UserRegister(String login, String firstName, String lastName, String password) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }
    //endregion
}



