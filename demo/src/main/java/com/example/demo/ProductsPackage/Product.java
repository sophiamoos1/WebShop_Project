package com.example.demo.ProductsPackage;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    @NotNull
    @Column(name = "title")
    private String title;
    @NotNull
    @Column(name = "description")
    private String description;
    @NotNull
    @Column(name = "price")
    private double price;
    @NotNull
    @Column(name = "weight")
    private String weight;
    @NotNull
    @Column(name = "picture")
    private String picture;



    public Product(){
    }

    public Product(int productId, String title, String description, double price, String weight, String picture) {
        this.productId = productId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.picture = picture;
    }
}
