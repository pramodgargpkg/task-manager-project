package com.pkgarg.taskmanager.Repository;

import com.pkgarg.taskmanager.Model.Task;
import com.pkgarg.taskmanager.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByUserIs(User user);
}
