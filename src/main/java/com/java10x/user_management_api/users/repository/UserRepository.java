package com.java10x.user_management_api.users.repository;

import com.java10x.user_management_api.users.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel,Long> {
}
