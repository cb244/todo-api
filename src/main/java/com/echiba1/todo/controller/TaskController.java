package com.echiba1.todo.controller;

import java.util.List;
import com.echiba1.todo.entity.TaskEntity;
import com.echiba1.todo.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    // GET
    @RequestMapping(value = "/api/tasks", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TaskEntity> getTaskList(@RequestParam(name = "sort", required = false) String sort) {
        return taskService.findAll();
    }

    @RequestMapping(value = "/api/tasks/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public TaskEntity getTaskById(@PathVariable int id) {
        return taskService.findById(id);
    }

    // POST
    @RequestMapping(value = "/api/tasks", method = RequestMethod.POST)
    public void createTask(@RequestBody TaskEntity taskEntity) {
        System.out.println(taskEntity);
        taskService.create(taskEntity);
    }

    // PUT
    @RequestMapping(value = "/api/tasks/{id}", method = RequestMethod.PUT)
    public void updateTaskById(@PathVariable int id, @RequestBody TaskEntity taskEntity) {
        taskService.updateById(id, taskEntity);
    }

    // DELETE
    @RequestMapping(value = "/api/tasks/{id}", method = RequestMethod.DELETE)
    public void deleteTaskById(@PathVariable int id) {
        taskService.deleteById(id);
    }
}