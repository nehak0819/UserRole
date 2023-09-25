package com.UserRole.Service;

import java.util.List;

import com.UserRole.Entity.User;

public interface UserService {

    User getUserById(Long userId);

    User getUserByUsername(String username);

    List<User> getAllUsers();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Long userId);

}