package com.haier.controller.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.haier.model.ContentEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class ContentForTypeResp implements Serializable {


    private Integer type;

    List<ContentEntity> categoryList;


}
