package com.example.demo.ShopUserPackage;


import com.example.demo.CardPackage.Card;
import com.example.demo.RolesPackage.Role;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "shopper")
public class ShopUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @OneToMany(mappedBy="user")
    private List<Card> orders;

    public ShopUser() {
    }

    public ShopUser(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public ShopUser(UUID userId, String email, String password, String name, String lastname) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {return this.password;}
    @Override
    public String getUsername() {return this.email;}
    @Override
    public boolean isAccountNonExpired() {return true;}
    @Override
    public boolean isAccountNonLocked() {return true;}
    @Override
    public boolean isCredentialsNonExpired() {return true;}
    @Override
    public boolean isEnabled() {return true;}
}

