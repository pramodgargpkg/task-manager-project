package com.pkgarg.taskmanager.Service;

import com.pkgarg.taskmanager.Model.Task;

import java.util.List;
import java.util.Optional;

public interface ITaskService {

    List<Task> findAll(int userId);

    Optional<Task> findById(int userId, int taskId);

    void saveTask(int userId, Task task);

    void deleteTask(int userId, int taskId);

    void deleteAllTasks(int userId);

    void updateTask(int userId, Task task);
}
