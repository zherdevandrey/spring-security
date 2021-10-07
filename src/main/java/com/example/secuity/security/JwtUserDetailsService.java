package com.example.secuity.security;

import com.example.secuity.model.User;
import com.example.secuity.security.jwt.JwtUser;
import com.example.secuity.security.jwt.JwtUserFactory;
import com.example.secuity.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = userService.findByUsername(userName);

        if (user == null){
            throw new UsernameNotFoundException("User with name {} was not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);
        log.debug("Jwt user with name created {}", user.getUsername());
        return jwtUser;
    }
}
