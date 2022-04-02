package com.pkgarg.taskmanager.Controller;

import com.pkgarg.taskmanager.Model.Task;
import com.pkgarg.taskmanager.Service.Service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final ITaskService taskService;

    @Autowired
    public TaskController(ITaskService theTaskService) {
        taskService = theTaskService;
    }

    @GetMapping("/{userId}")
    public List<Task> getTasks(@PathVariable int userId) {
        return taskService.findAll(userId);
    }

    @GetMapping("/{userId}/{taskId}")
    public Optional<Task> getTask(@PathVariable int userId, @PathVariable int taskId) {
        return taskService.findById(userId, taskId);
    }

    @PostMapping("/{userId}")
    public void saveTask(@PathVariable int userId, @RequestBody Task task) {
        task.setId(0);
        taskService.saveTask(userId, task);
    }

    @DeleteMapping("/{userId}/{taskId}")
    public void deleteTask(@PathVariable int userId, @PathVariable int taskId) {
        taskService.deleteTask(userId, taskId);
    }

    @DeleteMapping("/{userId}")
    public void deleteAllTasks(@PathVariable int userId) {
        taskService.deleteAllTasks(userId);
    }

    @PutMapping("/{userId}")
    public void updateTask(@PathVariable int userId, @RequestBody Task task) {
        taskService.updateTask(userId, task);
    }
}
