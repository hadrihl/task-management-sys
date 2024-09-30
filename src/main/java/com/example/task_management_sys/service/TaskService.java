package com.example.task_management_sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.task_management_sys.entity.Task;
import com.example.task_management_sys.repository.TaskRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).get();
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task task) {
        Task existingTask = taskRepository.findById(id).get();

        if(existingTask != null) {
            existingTask.setTitle(task.getTitle());
            existingTask.setDescription(task.getDescription());
            existingTask.setPriority(task.getPriority());
            existingTask.setCompleted(task.isCompleted());
            return taskRepository.save(existingTask);
        }

        return null;
    }
    
    public boolean deleteTask(Long id) {
        Task existingTask = taskRepository.findById(id).orElse(null);

        if(existingTask != null) {
            taskRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
