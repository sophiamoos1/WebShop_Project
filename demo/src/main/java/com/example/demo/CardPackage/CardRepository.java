package com.example.demo.CardPackage;

import com.example.demo.ShopUserPackage.ShopUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, Integer> {
    Card findByUser(ShopUser ShopUser);
}