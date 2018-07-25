package com.haier.controller.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.haier.model.ContentEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class ContentForCityResp implements Serializable {


    private String city;

    List<ContentEntity> typeList;

    @JsonIgnore
    Map<Integer,ContentEntity> typeMap ;


}
