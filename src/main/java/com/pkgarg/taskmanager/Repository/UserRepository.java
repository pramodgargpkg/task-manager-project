package com.pkgarg.taskmanager.Repository;


import com.pkgarg.taskmanager.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
