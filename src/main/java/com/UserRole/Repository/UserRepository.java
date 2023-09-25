package com.UserRole.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UserRole.Entity.User;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

 

}