package com.wawrzacz.mgrtaskbackend.Model;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

    //region Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String login;
    private String firstName;
    private String lastName;
    private String password;

    private Iterable<Task> createdTasks;
    private Iterable<Task> assignedTasks;
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

    public Iterable<Task> getCreatedTasks() { return createdTasks; }
    public void setCreatedTasks(Iterable<Task> createdTasks) { this.createdTasks = createdTasks; }

    public Iterable<Task> getAssignedTasks() { return assignedTasks; }
    public void setAssignedTasks(Iterable<Task> assignedTasks) { this.assignedTasks = assignedTasks; }
    //endregion

    //region Constructors
    public User() {
    }
    //endregion
}



