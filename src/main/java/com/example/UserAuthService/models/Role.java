package com.example.UserAuthService.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "CustomerRole")
public class Role extends BaseModel{

    private String name;

//    If needed, we can add list of permissions as well

}
