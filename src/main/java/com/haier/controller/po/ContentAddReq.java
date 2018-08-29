package com.haier.controller.po;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ContentAddReq {

    private Long moduleId;

    private String city;

    private Integer status;

    private String entryTime;

    private Integer type;

    private String content;

    private String remark;//备注

    private Long categoryId;

    private String effectTime;

    private String validTime;

    private Integer maxPeriod;

    private Integer cappingPeriod;

}
