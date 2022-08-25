package com.example.demo.CardPackage;

import com.example.demo.ProductsPackage.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceNotFoundException;
import java.util.Optional;

@RestController
@CrossOrigin()
@RequestMapping("/cart")
public class CardWeb {
    private final CardService service;

    public CardWeb(CardService service){
        this.service = service;
    }


    @GetMapping("/{orderId}")
    public ResponseEntity<Optional<Card>> find(@PathVariable("orderId") Integer orderId) throws InstanceNotFoundException {
        Optional<Card> card = service.find(orderId);
        return ResponseEntity.ok(card);
    }


    @PutMapping("/add/{orderId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Optional<Card>> update(@PathVariable("orderId") Integer orderId, @RequestBody Product product) throws InstanceNotFoundException {
        Optional<Card> updated = service.update(orderId, product);
        return ResponseEntity.ok().body(updated);
    }

    @ExceptionHandler
    public ResponseEntity<String> ExeptionHandler(Exception request){
        return ResponseEntity.status(404).body(request.getMessage());
    }
}
