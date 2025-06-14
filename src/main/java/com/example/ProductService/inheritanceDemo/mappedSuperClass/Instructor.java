package com.example.ProductService.inheritanceDemo.mappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "mcs_instructor")
public class Instructor extends User{

    private String subject;
    private Double rating;

}
