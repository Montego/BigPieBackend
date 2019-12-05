package com.bigpie.big_pie_project.repository;

import com.bigpie.big_pie_project.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByName(String name);
}
