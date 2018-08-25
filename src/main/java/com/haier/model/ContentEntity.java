package com.haier.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class ContentEntity {

    private Long id;

    private String city;

    private String entryTime;

    private Integer type;

    private String content;

    private Integer status;


    @JsonIgnore
    private Long createdBy;
//    @JsonIgnore
    private Date createdTime;
    @JsonIgnore
    private Long updatedBy;
    @JsonIgnore
    private Date updatedTime;
    @JsonIgnore
    private Long deletedBy;
    @JsonIgnore
    private Date    deletedTime;
    @JsonIgnore
    private Boolean isDelete;



}
