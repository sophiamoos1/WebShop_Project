package com.example.demo.ShopUserPackage;


import com.example.demo.CardPackage.Card;
import com.example.demo.ProductsPackage.Product;
import com.example.demo.RolesPackage.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
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
    @ManyToOne
    @JoinColumn(name="role_id", referencedColumnName="id")
    private Role role;
    /*@OneToMany(mappedBy="user")
    private List<Card> orders;*/
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

