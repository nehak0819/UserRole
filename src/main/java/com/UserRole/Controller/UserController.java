package com.UserRole.Controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

 



import com.UserRole.Entity.User;
import com.UserRole.Service.UserService;
 
@RestController
@RequestMapping("/users")
public class UserController {
     
        @Autowired
        private UserService userService;

        @GetMapping("/")
        public List<User> getAllUsers() {
            return userService.getAllUsers();

        }

        @GetMapping("/{id}")
        public User getUserById(@PathVariable Long id) {
            return userService.getUserById(id);

        }

        @PostMapping("/")
        public void createUser(@RequestBody User user) {
            userService.saveUser(user);

        }

        @PutMapping("/")
        public void updateUser(@RequestBody User user) {
            userService.updateUser(user);

        }

 

        @DeleteMapping("/{id}")
        public void deleteUser(@PathVariable Long id) {
            userService.deleteUser(id);

        }

   

   

}