package com.haier.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
public class ModuleItemEntity {

    private Long id;

    private Long moduleId;

    private String itemName;

    private Integer contentType;

    private String thumUrl;

    private String backgroundUrl;

    private String detailUrl;

    private String detailDesc;

    private Integer moduleOrder;

    private Boolean isDeleted;

    private String searchAttr;

    private Integer status;

    private String headlines;

    public ModuleItemEntity() {
    }

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
