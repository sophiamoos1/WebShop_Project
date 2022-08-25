package com.example.demo.CardPackage;


import com.example.demo.AuthorityPackage.Authority;
import com.example.demo.ProductsPackage.Product;
import com.example.demo.RolesPackage.Role;
import com.example.demo.ShopUserPackage.ShopUser;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "shoppingcard")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @ManyToOne
    @JsonBackReference
    private ShopUser user;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = @JoinColumn(
                    name = "order_id", referencedColumnName = "orderId"),
            inverseJoinColumns = @JoinColumn(
                    name = "productId", referencedColumnName = "productId"))
    private Set<Product> products;


    public Card(){

    }

    public Card(int orderId) {
        this.orderId = orderId;
    }

    public Card(ShopUser user){
        this.user = user;
    }

}
