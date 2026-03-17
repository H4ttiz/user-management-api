package com.java10x.user_management_api.tasks.model.entity;

import com.java10x.user_management_api.tasks.model.enums.Difficulty;
import com.java10x.user_management_api.users.model.UserModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tasks")
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Difficulty difficulty;

    // @OneToMany: A task can have several users
    @OneToMany(mappedBy = "tasks")
    private List<UserModel> users;


    public TaskModel() {
    }

    public TaskModel(String name, String description, Difficulty difficulty) {
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
}
