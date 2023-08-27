package com.mymovieplan.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mymovieplan.project.model.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

}
