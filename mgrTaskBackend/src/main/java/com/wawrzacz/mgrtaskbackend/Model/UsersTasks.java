package com.wawrzacz.mgrtaskbackend.Model;

import javax.persistence.*;

@Entity
@Table(name="usersTasks")
public class UsersTasks {

    //region Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long userId;
    private long taskId;
    //endregion

    //region Getters and setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public long getUserId() { return userId; }
    public void setUserId(long userId) { this.userId = userId; }

    public long getTaskId() { return taskId; }
    public void setTaskId(long taskId) { this.taskId = taskId; }
    //endregion

    //region Constructors
    public UsersTasks() {}
    //endregion
}