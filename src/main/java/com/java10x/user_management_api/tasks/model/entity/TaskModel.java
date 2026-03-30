package com.java10x.user_management_api.tasks.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.java10x.user_management_api.tasks.model.enums.Difficulty;
import com.java10x.user_management_api.users.model.entity.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Difficulty difficulty;

    // @OneToMany: A task can have several users
    @OneToMany(mappedBy = "tasks")
    @JsonIgnore
    private List<UserModel> users;
}
