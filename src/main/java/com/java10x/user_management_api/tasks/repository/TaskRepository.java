package com.java10x.user_management_api.tasks.repository;

import com.java10x.user_management_api.tasks.model.entity.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskModel,Long> {
}
