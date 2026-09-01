package com.example.ProductService.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity(name = "categories")
public class Category extends BaseModel implements Serializable {
//    @Column(unique = true,nullable = false)
    private String title;
    @OneToMany(mappedBy = "category", cascade = jakarta.persistence.CascadeType.REMOVE)
    @JsonIgnore
    List<Product> products;
}
