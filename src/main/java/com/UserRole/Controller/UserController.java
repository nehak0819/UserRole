package com.UserRole.Controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

        @RequestMapping("/All")
        public List<User> getAllUsers(ModelMap model) {
        	return   userService.getAllUsers();
        
        }

        @GetMapping("/{id}")
        public User getUserById(@PathVariable Long id) {
            return userService.getUserById(id);

        }

        @PostMapping( "/save")
        public void saveUser(@RequestBody User user, ModelMap model) {
        	userService.saveUser(user);

        }

        @PutMapping("/update/{id}")
        public void updateUser(@RequestBody User user ,@PathVariable Long id) {
            userService.updateUser(id, user);

        }
 
        @DeleteMapping("/delete/{id}")
        public void deleteUser(@PathVariable Long id) {
            userService.deleteUser(id);

        }

}