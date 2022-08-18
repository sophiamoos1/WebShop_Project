package com.example.demo.ShopUserPackage;

import com.example.demo.UserPackage.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.management.InstanceNotFoundException;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin()
@RequestMapping("/account")
public class ShopUserWeb {
    private final ShopUserService service;

    public ShopUserWeb(ShopUserService service){
        this.service = service;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ShopUser> find(@PathVariable("userId") UUID userId) throws InstanceNotFoundException {
        ShopUser user = service.find(userId);
        return ResponseEntity.ok(user);
    }



    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ShopUser> newUser(@RequestBody ShopUser user) {
        ShopUser created = service.create(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{userId}")
                .buildAndExpand(created.getUserId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }


    @PutMapping("/edit/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ShopUser> update(@PathVariable("userId") UUID userId, @RequestBody ShopUser updatedUser) throws InstanceNotFoundException {
        ShopUser updated = service.update(userId, updatedUser);
        return ResponseEntity.ok().body(updated);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ShopUser> delete(@PathVariable("userId") UUID userId)throws InstanceNotFoundException {
        service.delete(userId);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler
    public ResponseEntity<String> ExeptionHandler(Exception request){
        return ResponseEntity.status(404).body(request.getMessage());
    }
}
