package com.example.ProductService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity(name = "products")
public class Product extends BaseModel implements Serializable {

    private String title;
    private Double price;
    private String description;
    private String imageUrl;
    @ManyToOne(cascade = {jakarta.persistence.CascadeType.PERSIST})
    @JoinColumn
    private Category category;

}
