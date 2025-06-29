package com.example.UserAuthService.models;

import java.util.Date;

public abstract class BaseModel {

    private Long id;

    private Date createdAt;

    private Date lastUpdatedAt;

    private String createdBy;

    private State state;

}
