package com.first.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.first.blog.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
