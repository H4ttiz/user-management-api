package com.java10x.user_management_api.users.model;


import com.java10x.user_management_api.tasks.model.entity.TaskModel;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    // @ManyToOne: A user has a single task
    @ManyToOne
    @JoinColumn(name = "id_tasks")
    private TaskModel tasks;

}
