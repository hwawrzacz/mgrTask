package com.wawrzacz.mgrtaskbackend.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="tasks")
public class Task {

    //region Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String category;
    private String priority;
    private String status;
    private String description;
    private Date creationDate;
    private Date expirationDate;

    @ManyToOne
    private User author;

    @ManyToOne
    private User receiver;
    //endregion

    // region Getters and setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public User getAuthor() {return author; }

    public void setAuthor(User author) { this.author = author; }

    public User getReceiver() { return receiver; }
    public void setReceiver(User receiver) { this.receiver = receiver; }

    public Date getCreationDate() { return creationDate; }
    public void setCreationDate(Date creationDate) { this.creationDate = creationDate; }

    public Date getExpirationDate() { return expirationDate; }
    public void setExpirationDate(Date expirationDate) { this.expirationDate = expirationDate; }
    //endregion

    //region Constructors
    public Task() { }

    public Task(String name, String category, String status, String priority, String description,
                Date creationDate, Date expirationDate, User author, User receiver) {
        this.name = name;
        this.category = category;
        this.status = status;
        this.priority = priority;
        this.description = description;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.author = author;
        this.receiver = receiver;
    }

    public Task(long id, String name, String category, String status, String priority, String description,
                Date creationDate, Date expirationDate, User author, User receiver) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.status = status;
        this.priority = priority;
        this.description = description;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.author = author;
        this.receiver = receiver;
    }
    //endregion
}

