package com.haier.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class BaseEntity {

    @JsonIgnore
    private Long createdBy;
    private Date createdTime;
    @JsonIgnore
    private Long updatedBy;
    private Date    updatedTime;
    @JsonIgnore
    private Long deletedBy;
    private Date    deletedTime;
}
