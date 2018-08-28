package com.haier.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class CategoryEntity {

    private Long id;
    private Integer categoryType;
    private String categoryName;
    @JsonIgnore
    private int sort;

    @JsonIgnore
    private int createdBy;
    @JsonIgnore
    private Date createdTime;
    @JsonIgnore
    private int updatedBy;
    @JsonIgnore
    private Date updatedTime;
    @JsonIgnore
    private int deletedBy;
    @JsonIgnore
    private Date deletedTime;
    @JsonIgnore
    private Boolean isDeleted;

}
