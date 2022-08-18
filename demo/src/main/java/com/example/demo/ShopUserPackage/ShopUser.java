package com.example.demo.ShopUserPackage;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "shopper")
public class ShopUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
    @NotNull
    @Column(name = "email")
    private String email;
    @NotNull
    @Column(name = "password")
    private String password;
    @NotNull
    @Column(name = "name")
    private String name;
    @NotNull
    @Column(name = "lastname")
    private String lastname;

    public ShopUser() {
    }

    public ShopUser(UUID userId, String email, String password, String name, String lastname) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
    }
}

