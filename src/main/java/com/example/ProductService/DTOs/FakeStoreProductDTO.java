package com.example.ProductService.DTOs;

import com.example.ProductService.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {

    private Long id;
    private String title;
    private Double price;
    private String description;
    private String image;
    private String category;

}
