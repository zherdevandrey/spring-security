package com.example.springsecurity.db;

import com.example.springsecurity.model.User;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class DbInit implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) {

        userRepository.deleteAll();

        User user = new User("user", passwordEncoder.encode("user"), "USER", "");
        User admin = new User("admin", passwordEncoder.encode("admin"), "ADMIN", "ACCESS_TEST1,ACCESS_TEST2");
        User manager = new User("manager", passwordEncoder.encode("manager"), "MANAGER", "ACCESS_TEST1");
        List<User> users = Arrays.asList(user, admin, manager);

        userRepository.saveAll(users);
    }
}
