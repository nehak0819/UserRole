package com.UserRole.ServiceImpl;
import java.util.List;
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

        return userRepository.findAll();

    }

 
    @Override

    public void saveUser(User user) {

        userRepository.save(user);

    }

 
    @Override

    public void updateUser(User user) {

        userRepository.save(user);

    }

 
    @Override

    public void deleteUser(Long userId) {

        userRepository.deleteById(userId);

    }



}