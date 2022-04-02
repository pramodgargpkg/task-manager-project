package com.pkgarg.taskmanager.Service.Service;

import com.pkgarg.taskmanager.Model.User;
import com.pkgarg.taskmanager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository theUserRepository) {
        userRepository = theUserRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new RuntimeException("User id not found - " + id);
        }

        return user.get();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }
}
