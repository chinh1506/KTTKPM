package com.example.jwtextuan3.repository;

import com.example.jwtextuan3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Integer, User> {
}
