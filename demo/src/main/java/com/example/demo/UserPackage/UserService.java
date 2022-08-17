package com.example.demo.UserPackage;


import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
public class UserService{
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        Iterable<User> users = userRepository.findAll();
        users.forEach(list::add);
        return list;
    }

    public User find(UUID userId) throws InstanceNotFoundException {
        return userRepository.findById(userId).orElseThrow(() -> new InstanceNotFoundException("The User with the Id: " + userId + " was not Found"));
    }

    public User create(User user) {

        User copy = new User(
                user.getUserId(),
                user.getUsername(),
                user.getPassword()
        );
        return userRepository.save(copy);
    }


    public User update(UUID userId, User newUser) throws InstanceNotFoundException {
        if(userRepository.existsById(userId)) {
            return userRepository.findById(userId)
                    .map(oldUser -> {
                        oldUser.setUsername(newUser.getUsername());
                        oldUser.setPassword(newUser.getPassword());
                        return userRepository.save(oldUser);
                    }).orElseThrow(() -> new InstanceNotFoundException("The User with the Id: " + userId + " was not Found"));
        }else{

            newUser.setUsername(newUser.getUsername());
            newUser.setPassword(newUser.getPassword());

            return userRepository.save(newUser);
        }
    }

    public void delete(UUID userId) throws InstanceNotFoundException {

        userRepository.findById(userId).orElseThrow(() -> new InstanceNotFoundException("The User with the Id: " + userId + " was not Found"));
        userRepository.deleteById(userId);
    }


}
