package com.example.demo.ProductsPackage;


import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;
import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService {

    private final ProductRespository productRepository;


    public ProductService(ProductRespository productRepository) {

        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        Iterable<Product> products = productRepository.findAll();
        products.forEach(list::add);
        return list;
    }

    public Product find(Integer productId) throws InstanceNotFoundException {
        return productRepository.findById(productId).orElseThrow(() -> new InstanceNotFoundException("The Product with the Id: " + productId + " was not Found"));
    }

    public Product create(Product product) {

        Product copy = new Product(
                product.getProductId(),
                product.getTitle(),
                product.getDescription(),
                product.getPrice(),
                product.getWeight(),
                product.getPicture()
        );
        return productRepository.save(copy);
    }


    public Product update(Integer productId, Product newproduct) throws InstanceNotFoundException {
        if(productRepository.existsById(productId)) {
            return productRepository.findById(productId)
                    .map(oldProduct -> {
                        oldProduct.setTitle(newproduct.getTitle());
                        oldProduct.setDescription(newproduct.getDescription());
                        oldProduct.setPrice(newproduct.getPrice());
                        oldProduct.setWeight(newproduct.getWeight());
                        oldProduct.setPicture(newproduct.getPicture());
                        return productRepository.save(oldProduct);
                    }).orElseThrow(() -> new InstanceNotFoundException("The Product with the Id: " + productId + " was not Found"));
        }else{

            newproduct.setTitle(newproduct.getTitle());
            newproduct.setDescription(newproduct.getDescription());
            newproduct.setPrice(newproduct.getPrice());
            newproduct.setWeight(newproduct.getWeight());
            newproduct.setPicture(newproduct.getPicture());

            return productRepository.save(newproduct);
        }
    }

    public void delete(Integer productId) throws InstanceNotFoundException {

        productRepository.findById(productId).orElseThrow(() -> new InstanceNotFoundException("The Product with the Id: " + productId + " was not Found"));
        productRepository.deleteById(productId);
    }


}
