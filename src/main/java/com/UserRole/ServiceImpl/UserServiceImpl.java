package com.UserRole.ServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.UserRole.Entity.User;
import com.UserRole.Repository.UserRepository;
import com.UserRole.Service.UserService;

@Service

public class UserServiceImpl implements UserService {
    @Autowired

    private UserRepository userRepository;

       @Override

    public User getUserById(Long userId) {

        return userRepository.findById(userId).orElse(null);

    }

 
    @Override

    public User getUserByUsername(String username) {

        return userRepository.findByUsername(username);

    }

 
    @Override

    public List<User> getAllUsers() {
    	List<User> All = new ArrayList<>();
        userRepository.findAll().forEach(All::add);;
        return All;

    }

 
    @Override

    public void saveUser(User user) {

        userRepository.save(user);

    }

 
   
    @Override
public void updateUser(Long id , User updatedUser) {

        Optional<User> findById = userRepository.findById(id);
        User user = findById.get();
        user.setPassword(updatedUser.getPassword());
        user.setUsername(updatedUser.getUsername());
        userRepository.save(user);
       

    }

 
    @Override

    public void deleteUser(Long userId) {

        userRepository.deleteById(userId);

    }



}