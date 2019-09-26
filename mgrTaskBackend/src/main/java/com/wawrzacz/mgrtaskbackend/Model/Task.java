package com.wawrzacz.mgrtaskbackend.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private String description;
    private Date creationDate;
    private Date expirationDate;

    @ManyToOne
    //@JsonIgnore
    @JsonBackReference(value = "author")
    private User author;

    @ManyToOne
    //@JsonIgnore
    @JsonBackReference(value = "receiver")
    private User receiver;
    //endregion

    // region Getters and setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public User getAuthor() {return author; }

    public void setAuthor(User author) { this.author = author; }

    public User getReceiver() { return receiver; }
    public void setReceiver(User intendedFor) { this.receiver = intendedFor; }

    public Date getCreationDate() { return creationDate; }
    public void setCreationDate(Date creationDate) { this.creationDate = creationDate; }

    public Date getExpirationDate() { return expirationDate; }
    public void setExpirationDate(Date dutyDate) { this.expirationDate = dutyDate; }
    //endregion

    //region Constructors
    public Task() { }

    public Task(String name, String category, String description, Date creationDate, Date expirationDate,
                User author, User receiver) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.author = author;
        this.receiver = receiver;
    }

    public Task(long id, String name, String category, String description, Date creationDate, Date expirationDate,
                User author, User receiver) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.author = author;
        this.receiver = receiver;
    }
    //endregion
}

    