package com.UserRole.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

 




import com.UserRole.Entity.Role;
import com.UserRole.Entity.User;
import com.UserRole.Service.RoleService;
import com.UserRole.Service.UserService;

@RestController

@RequestMapping("/admin")

public class AdminController {

    @Autowired
    private UserService userService;

     @Autowired
    private RoleService roleService;

   

    @PostMapping("/grant/{userId}/{roleName}")
    public void grantPermission(@PathVariable Long userId, @PathVariable String roleName) {
        User user = userService.getUserById(userId);
        Role role = roleService.getRoleByName(roleName);     
        if (user != null && role != null) {
            user.getRoles().add(role);
            userService.updateUser(userId, user);

        }

    }

   

    @PostMapping("/revoke/{userId}/{roleName}")
    public void revokePermission(@PathVariable Long userId, @PathVariable String roleName) {
        User user = userService.getUserById(userId);
        Role role = roleService.getRoleByName(roleName);     
        if (user != null && role != null) {
            user.getRoles().remove(role);
            userService.updateUser(userId, user );

        }

    }

}