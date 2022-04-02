package com.pkgarg.taskmanager.Controller;

import com.pkgarg.taskmanager.Model.User;
import com.pkgarg.taskmanager.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService theUserService) {
        userService = theUserService;
    }

    @GetMapping("/")
    public Iterable<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable int userId) {
        return userService.findById(userId);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        user.setId(0);
        userService.save(user);
        return user;
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return user;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable int userId) {
        userService.deleteById(userId);
        return "Deleted user with userId- " + userId;
    }
}
