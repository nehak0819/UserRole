package com.UserRole.ServiceImpl;

import com.UserRole.Entity.Role;
import com.UserRole.Service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.UserRole.Repository.RoleRepository;

@Service

public class RoleServiceImpl implements RoleService {
 
     @Autowired

        private RoleRepository roleRepository;

        @Override

        public Role getRoleByName(String roleName) {

            return roleRepository.findByName(roleName);

        }

}