package com.bigpie.big_pie_project.security;

import com.bigpie.big_pie_project.entity.User;
import com.bigpie.big_pie_project.security.jwt.JwtUser;
import com.bigpie.big_pie_project.security.jwt.JwtUserFactory;
import com.bigpie.big_pie_project.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.getOneByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User with username: " + username + "not exists");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);
        log.info("IN JwtUserDetailsService IN loadUserByUsername - user with username: {} successfully loaded", username);
        return jwtUser;
    }
}
