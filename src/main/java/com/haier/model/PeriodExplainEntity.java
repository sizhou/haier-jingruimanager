package com.haier.model;

import com.haier.controller.po.ContentAddReq;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class PeriodExplainEntity extends BaseEntity {


    private Long id;
    private String effectTime;
    private String validTime;
    private Integer maxPeriod;
    private Integer cappingPeriod;

    public PeriodExplainEntity converTo(ContentAddReq contentAddReq,PeriodExplainEntity entity){
        entity.setEffectTime(contentAddReq.getEffectTime())
                .setValidTime(contentAddReq.getValidTime())
                .setMaxPeriod(contentAddReq.getMaxPeriod())
                .setCappingPeriod(contentAddReq.getCappingPeriod());
        return entity;
    }

}
