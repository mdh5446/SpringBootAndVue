package com.example.mdh_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mdh_test.entity.*;

public interface ShopUserRepository extends JpaRepository<ShopUser, Long> {
}