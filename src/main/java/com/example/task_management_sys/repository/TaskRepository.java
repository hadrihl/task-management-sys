package com.example.task_management_sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.task_management_sys.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
