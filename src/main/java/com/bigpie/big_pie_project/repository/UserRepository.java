package com.bigpie.big_pie_project.repository;

import com.bigpie.big_pie_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserByUsername(String login);

}
