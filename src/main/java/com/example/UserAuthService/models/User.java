package com.example.UserAuthService.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "Customer")
public class User extends BaseModel{

    private String name;

    private String email;

    private String password;

    private String phoneNumber;

//    For Many to many cardinality, remove is maybe not appropriate
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private List<Role> roles;

}
