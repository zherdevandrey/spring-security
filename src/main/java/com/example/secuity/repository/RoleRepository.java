package com.example.secuity.repository;

import com.example.secuity.model.Role;
import com.example.secuity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
