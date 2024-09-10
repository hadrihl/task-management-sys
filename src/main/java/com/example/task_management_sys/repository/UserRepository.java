package com.example.task_management_sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.task_management_sys.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
