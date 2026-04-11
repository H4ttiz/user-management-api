package com.java10x.user_management_api.users.model.entity;


import com.java10x.user_management_api.tasks.model.entity.TaskModel;
import com.java10x.user_management_api.users.model.enums.Role;
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

    @Column(unique = true)
    private String email;

    private String password;

    private Role role;

    @ManyToOne
    @JoinColumn(name = "id_tasks")
    private TaskModel tasks;

}
