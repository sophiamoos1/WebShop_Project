package com.example.demo.ShopUserPackage;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShopUserRepository extends JpaRepository<ShopUser, UUID> {
    ShopUser findByEmail (String email);
}
