package com.UserRole.Service;

import java.util.List;

import com.UserRole.Entity.User;

public interface UserService {

    User getUserById(Long userId);

    User getUserByUsername(String username);

    List<User> getAllUsers();

    void saveUser(User user);

    public void updateUser(Long id, User updatedUser);

    void deleteUser(Long userId);

}