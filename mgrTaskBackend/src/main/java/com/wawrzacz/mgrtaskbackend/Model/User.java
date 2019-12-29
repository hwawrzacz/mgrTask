package com.wawrzacz.mgrtaskbackend.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    //region Fields
    @Id
    private String login;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "author")
        @JsonBackReference(value = "authorReference")
//    @JsonIgnore
    private List<Task> createdTasks;

    @OneToMany(mappedBy = "receiver")
    @JsonBackReference(value = "receiverReference")
//    @JsonIgnore
    private List<Task> assignedTasks;
    //endregion

    //region Getters and setters
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public List<Task> getCreatedTasks() { return createdTasks; }
    public void setCreatedTasks(List<Task> createdTasks) { this.createdTasks = createdTasks; }

    public List<Task> getAssignedTasks() { return assignedTasks; }
    public void setAssignedTasks(List<Task> assignedTasks) { this.assignedTasks = assignedTasks; }
    //endregion

    //region Constructors
    public User() { }

    public User(UserRegister user) {
        this.login = user.getLogin();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
    }

    public User(String login, String firstName, String lastName) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    //endregion
}



