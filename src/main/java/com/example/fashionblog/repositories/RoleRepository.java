package com.example.fashionblog.repositories;

import com.example.fashionblog.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<UserRole,Long> {
}
