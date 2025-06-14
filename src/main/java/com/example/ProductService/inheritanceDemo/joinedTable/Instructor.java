package com.example.ProductService.inheritanceDemo.joinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_instructors")
@PrimaryKeyJoinColumn(name = "id")
public class Instructor extends User {

    private String subject;
    private Double rating;

}
