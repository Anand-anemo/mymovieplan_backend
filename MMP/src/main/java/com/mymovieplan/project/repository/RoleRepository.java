package com.mymovieplan.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymovieplan.project.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {

}
