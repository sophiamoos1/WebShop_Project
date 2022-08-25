package com.example.demo.ProductsPackage;

import com.example.demo.ProductsPackage.Product;
import com.example.demo.ProductsPackage.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.management.InstanceNotFoundException;
import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/product")
public class ProductWeb {
    private final ProductService service;


    public ProductWeb(ProductService service) {
        this.service = service;
    }


    @GetMapping("/{productId}")
    public ResponseEntity<Product> find(@PathVariable("productId") Integer productId) throws InstanceNotFoundException {
        Product product = service.find(productId);
        return ResponseEntity.ok(product);
    }


    @GetMapping("/all")
    public ResponseEntity<List<Product>> findAll() {
        List<Product> product = service.findAll();
        return ResponseEntity.ok().body(product);
    }


    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Product> newProduct(@RequestBody Product product) {
        Product created = service.create(product);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{productId}")
                .buildAndExpand(created.getProductId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }


    @PutMapping("/edit/{productId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Product> update(@PathVariable("productId") Integer productId, @RequestBody Product updatedProduct) throws InstanceNotFoundException {
        Product updated = service.update(productId, updatedProduct);
        return ResponseEntity.ok().body(updated);
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<Product> delete(@PathVariable("productId") Integer productId) throws InstanceNotFoundException {
        service.delete(productId);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler
    public ResponseEntity<String> ExeptionHandler(Exception request) {
        return ResponseEntity.status(404).body(request.getMessage());
    }

}