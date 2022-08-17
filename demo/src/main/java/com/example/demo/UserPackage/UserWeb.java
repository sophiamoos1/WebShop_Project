package com.example.demo.UserPackage;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.management.InstanceNotFoundException;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserWeb {
    private final UserService service;


    public UserWeb(UserService service) {
        this.service = service;
    }

    
    @GetMapping("/{userId}")
    public ResponseEntity<User> find(@PathVariable("userId") UUID userId) throws InstanceNotFoundException {
        User user = service.find(userId);
        return ResponseEntity.ok(user);
    }


    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> user = service.findAll();
        return ResponseEntity.ok().body(user);
    }


    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<User> newUser(@RequestBody User user) {
        User created = service.create(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{userId}")
                .buildAndExpand(created.getUserId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }


    @PutMapping("/edit/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> update(@PathVariable("userId") UUID userId, @RequestBody User updatedUser) throws InstanceNotFoundException {
        User updated = service.update(userId, updatedUser);
        return ResponseEntity.ok().body(updated);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<User> delete(@PathVariable("userId") UUID userId)throws InstanceNotFoundException {
        service.delete(userId);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler
    public ResponseEntity<String> ExeptionHandler(Exception request){
        return ResponseEntity.status(404).body(request.getMessage());
    }

}