package com.wawrzacz.mgrtaskbackend.Model;


import javax.persistence.*;
import java.util.GregorianCalendar;

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
    private String creationDate;
    private String dutyDate;

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

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public User getAuthor() {return author; }

    public void setAuthor(User author) { this.author = author; }

    public User getIntendedFor() { return receiver; }
    public void setIntendedFor(User intendedFor) { this.receiver = intendedFor; }

    public String getCreationDate() { return creationDate; }
    public void setCreationDate(String creationDate) { this.creationDate = creationDate; }

    public String getDutyDate() { return dutyDate; }
    public void setDutyDate(String dutyDate) { this.dutyDate = dutyDate; }
    //endregion

    //region Constructors
    public Task() { }

    public Task(long id, String name, String category, String description, String creationDate, String dutyDate,
                User author, User receiver) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.creationDate = creationDate;
        this.dutyDate = dutyDate;
        this.author = author;
        this.receiver = receiver;
    }

    public Task(String name, String category, String description, String creationDate, String dutyDate,
                User author, User receiver) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.creationDate = creationDate;
        this.dutyDate = dutyDate;
        this.author = author;
        this.receiver = receiver;
    }
    //endregion
}

    