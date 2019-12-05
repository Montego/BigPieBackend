package com.bigpie.big_pie_project.service;

import com.bigpie.big_pie_project.entity.Role;
import com.bigpie.big_pie_project.entity.Status;
import com.bigpie.big_pie_project.entity.User;
import com.bigpie.big_pie_project.repository.RoleRepository;
import com.bigpie.big_pie_project.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String register(User user) {
        Role role = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(role);
//TODO add solt
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);

        try {
            User registeredUser = userRepository.save(user);
            log.info("IN UserService, IN register - user : {} successfully registered", registeredUser);
            return "saved";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public User getOneByUsername(String username) {
        try {
            User userByUsername = userRepository.getUserByUsername(username);
            log.info("IN UserService, IN getOneByUsername - user: {} found by username: {}", userByUsername, username);
            return userByUsername;
        } catch (Exception e) {
            return null;
        }
    }

    public List<User> getAllUsers() {
        List<User> allUser = userRepository.findAll();
        log.info("IN UserService, IN getAllUsers - {} users found : ", allUser.size());
        return allUser;
    }

    public User getUserByID(Integer id) {
        User userById = userRepository.findById(id).orElse(null);
        if (userById == null) {
            log.warn("IN UserService, IN getUserByID - no user found by ID: {}", id);
            return null;
        }
        log.info("IN UserService, IN getUserByID - user: {} found by ID: {}", userById, id);
        return userById;
    }

//    public Boolean deleteOne(Integer id){
//
//    }
}
