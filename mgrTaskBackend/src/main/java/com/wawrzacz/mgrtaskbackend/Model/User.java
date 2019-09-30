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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String login;
    private String firstName;
    private String lastName;
    private String password;

    @OneToMany(mappedBy = "author")
    @JsonManagedReference(value = "authorReference")
    @JsonIgnore
    private List<Task> createdTasks;

    @OneToMany(mappedBy = "receiver")
    @JsonManagedReference(value = "receiverReference")
    @JsonIgnore
    private List<Task> assignedTasks;
    //endregion

    //region Getters and setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

//    public List<Task> getCreatedTasks() { return createdTasks; }
//    public void setCreatedTasks(List<Task> createdTasks) { this.createdTasks = createdTasks; }
//
//    public List<Task> getAssignedTasks() { return assignedTasks; }
//    public void setAssignedTasks(List<Task> assignedTasks) { this.assignedTasks = assignedTasks; }
    //endregion

    //region Constructors
    public User() { }

//    public User(String login, String firstName, String lastName, String password,
//                List<Task> createdTasks, List<Task> assignedTasks) {
//        this.login = login;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.password = password;
//        this.createdTasks = createdTasks;
//        this.assignedTasks = assignedTasks;
//    }

//    public User(long id, String login, String firstName, String lastName, String password,
//                List<Task> createdTasks, List<Task> assignedTasks) {
//        this.id = id;
//        this.login = login;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.password = password;
//        this.createdTasks = createdTasks;
//        this.assignedTasks = assignedTasks;
//    }

    public User(long id, String login, String firstName, String lastName, String password) {
        this.id = id;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }
    //endregion
}



