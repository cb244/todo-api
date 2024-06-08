package com.echiba1.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.echiba1.todo.entity.TaskEntity;
import com.echiba1.todo.repository.TaskRepository;

@Service
@Transactional
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<TaskEntity> findAll() {
        List<TaskEntity> tasks = taskRepository.findAll();
        System.out.println(tasks);
        return taskRepository.findAll();
    }

    public TaskEntity findById(int id) {
        return taskRepository.getReferenceById(id);
    }

    public void create(TaskEntity taskEntity) {
        taskRepository.save(taskEntity);
    }

    public void updateById(int id, TaskEntity taskEntity) {
        if (taskRepository.existsById(id)) {
            taskRepository.save(taskEntity);
        }
    }

    public void deleteById(int id) {
        taskRepository.deleteById(id);
    }
}
