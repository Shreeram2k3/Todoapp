package com.example.Todoapp.model;

import jakarta.persistence.*;

@Entity
@Table(name="Task_table")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String task;
    private boolean completed;

//    constructors for data fields
    public Todo(long id, String task, boolean completed) {
        this.id = id;
        this.task = task;
        this.completed = completed;
    }

//    default constructor for JPA
    public Todo() {
    }

    //    getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
