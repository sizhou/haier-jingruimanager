package com.haier.controller.po;

import com.haier.model.ContentEntity;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ContentPo extends ContentEntity {

    private String effectTime;
    private String validTime;
    private Integer maxPeriod;
    private Integer cappingPeriod;
}
