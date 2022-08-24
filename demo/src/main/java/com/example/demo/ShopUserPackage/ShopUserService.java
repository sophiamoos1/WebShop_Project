package com.example.demo.ShopUserPackage;

import com.example.demo.UserPackage.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
public class ShopUserService implements UserDetailsService {
    private final ShopUserRepository shopUserRepository;

    public ShopUserService(ShopUserRepository shopUserRepository) {
        this.shopUserRepository = shopUserRepository;
    }

        public List<ShopUser> findAll() {
            List<ShopUser> list = new ArrayList<>();
            Iterable<ShopUser> users = shopUserRepository.findAll();
            users.forEach(list::add);
            return list;
        }

    public ShopUser find(UUID userId) throws InstanceNotFoundException {
        return shopUserRepository.findById(userId).orElseThrow(() -> new InstanceNotFoundException("The User with the Id: " + userId + " was not Found"));
    }

    public ShopUser create(ShopUser user) {

        ShopUser copy = new ShopUser(
                user.getUserId(),
                user.getEmail(),
                user.getPassword(),
                user.getName(),
                user.getLastname()
        );
        return shopUserRepository.save(copy);
    }

    public ShopUser update(UUID userId, ShopUser newUser) throws InstanceNotFoundException {
        if(shopUserRepository.existsById(userId)) {
            return shopUserRepository.findById(userId)
                    .map(oldUser -> {
                        oldUser.setEmail(newUser.getEmail());
                        oldUser.setPassword(newUser.getPassword());
                        oldUser.setName(newUser.getName());
                        oldUser.setLastname(newUser.getLastname());
                        return shopUserRepository.save(oldUser);
                    }).orElseThrow(() -> new InstanceNotFoundException("The User with the Id: " + userId + " was not Found"));
        }else{

            newUser.setEmail(newUser.getEmail());
            newUser.setPassword(newUser.getPassword());
            newUser.setName(newUser.getName());
            newUser.setLastname(newUser.getLastname());

            return shopUserRepository.save(newUser);
        }
    }

    public void delete(UUID userId) throws InstanceNotFoundException {
        shopUserRepository.findById(userId).orElseThrow(() -> new InstanceNotFoundException("The User with the Id: " + userId + " was not Found"));
        shopUserRepository.deleteById(userId);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ShopUser user = shopUserRepository.findByEmail(username);
        if (user == null){
            throw new UsernameNotFoundException("User not found");
        }
        else {
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRole().getAuthorities().forEach(authority ->
                    authorities.add(new SimpleGrantedAuthority(authority.getName())));
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
        }

    }
}
