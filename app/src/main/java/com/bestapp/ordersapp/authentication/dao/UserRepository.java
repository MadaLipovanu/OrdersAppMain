package com.bestapp.ordersapp.authentication.dao;

import com.bestapp.ordersapp.authentication.model.persitance.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}