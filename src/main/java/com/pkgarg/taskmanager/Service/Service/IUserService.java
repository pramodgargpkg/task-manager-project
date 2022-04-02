package com.pkgarg.taskmanager.Service.Service;

import com.pkgarg.taskmanager.Model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User findById(int id);

    void save(User user);

    void deleteById(int id);

    void updateUser(User user);
}
