package com.example.demo.ProductsPackage;


import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductRespository extends JpaRepository<Product, Integer> {
    Product findByTitle(String title);
}
