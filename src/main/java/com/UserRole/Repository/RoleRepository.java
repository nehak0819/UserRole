package com.UserRole.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UserRole.Entity.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {

     Role findByName(String name);

 

}