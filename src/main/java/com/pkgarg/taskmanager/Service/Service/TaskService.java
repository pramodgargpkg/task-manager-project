package com.pkgarg.taskmanager.Service.Service;

import com.pkgarg.taskmanager.Model.Task;
import com.pkgarg.taskmanager.Model.User;
import com.pkgarg.taskmanager.Repository.TaskRepository;
import com.pkgarg.taskmanager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements ITaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final IUserService userService;

    @Autowired
    public TaskService(TaskRepository theTaskRepository, UserRepository theUserRepository, IUserService theUserService) {
        taskRepository = theTaskRepository;
        userRepository = theUserRepository;
        userService = theUserService;
    }


    @Override
    public List<Task> findAll(int userId) {
        User user = userService.findById(userId);
        return taskRepository.findByUserIs(user);
    }

    @Override
    public Optional<Task> findById(int userId, int taskId) {
        return taskRepository.findById(taskId);
    }

    @Override
    public void saveTask(int userId, Task task) {
        task.setUser(userRepository.getById(userId));
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(int userId, int taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        if (!task.isPresent()) {
            throw new RuntimeException("Task doesn't exist");
        }
        if (!userRepository.getById(userId).getTaskList().contains(task)) {
            throw new RuntimeException("User- " + userId + "is not the owner of task " + task.get().getTitle());
        }

        taskRepository.deleteById(taskId);
    }

    @Override
    public void deleteAllTasks(int userId) {
        List<Task> taskList = userRepository.getById(userId).getTaskList();
        taskRepository.deleteAllInBatch(taskList);
    }

    @Override
    public void updateTask(int userId, Task task) {
        Task t = taskRepository.getById(task.getId());
        if (t.getUser() != userRepository.getById(userId)) {
            throw new RuntimeException("User -" + userId + "is not the owner of task" + task);
        }
        taskRepository.save(task);
    }
}
