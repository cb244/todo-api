package com.echiba1.todo.service;

import java.util.List;
import java.util.Optional;

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
        for (TaskEntity taskEntity : tasks) {
            System.out.println(taskEntity);
        }
        return taskRepository.findAll();
    }

    public TaskEntity findById(int id) {
        Optional<TaskEntity> opt = taskRepository.findById(id);
        return opt.orElse(null);
    }

    public void create(TaskEntity taskEntity) {
        System.out.println(taskEntity);
        taskRepository.save(taskEntity);
    }

    public void updateById(int id, TaskEntity taskEntity) {
        TaskEntity targetTaskEntity = taskRepository.findById(id).get();
        System.out.println(targetTaskEntity);

        taskEntity.setId(id);
        taskEntity.setCreatedAt(targetTaskEntity.getCreatedAt());
        if (taskEntity.getContent() == null) {
            taskEntity.setContent(targetTaskEntity.getContent());
        }
        if (taskEntity.getDone() == null) {
            taskEntity.setDone(targetTaskEntity.getDone());
        }
        taskRepository.save(taskEntity);
    }

    public void deleteById(int id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return;
        }
        System.out.println("Not exists such TaskEntity");
    }
}
