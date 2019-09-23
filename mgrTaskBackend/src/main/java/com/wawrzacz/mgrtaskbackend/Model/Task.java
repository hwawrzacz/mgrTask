package com.wawrzacz.mgrtaskbackend.Model;

import javax.persistence.*;

@Entity
@Table(name="tasks")
public class Task {

    //region Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private String category;
    private String description;
    private User author;
    private Iterable<User> intendedFor;
    private String creationDate;
    private String dutyDate;
    //endregion

    // region Getters and setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public User getAuthor() {return author; }

    public void setAuthor(User author) { this.author = author; }

    public Iterable<User> getIntendedFor() { return intendedFor; }
    public void setIntendedFor(Iterable<User> intendedFor) { this.intendedFor = intendedFor; }

    public String getCreationDate() { return creationDate; }
    public void setCreationDate(String creationDate) { this.creationDate = creationDate; }

    public String getDutyDate() { return dutyDate; }
    public void setDutyDate(String dutyDate) { this.dutyDate = dutyDate; }
    //endregion

    //region Constructors
    public Task() {
    }
    //endregion
}

    