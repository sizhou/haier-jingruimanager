package com.haier.controller.po;

import com.haier.model.ContentEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ContentListResp {

    /**
     * 总条数
     */
    @ApiModelProperty(value = "总条数")
    private Integer total;

    /**
     * 页码.
     */
    @ApiModelProperty(value = "页码")
    private Integer pageNo;
    /**
     * 每页长度.
     */
    @ApiModelProperty(value = "每页长度")
    private Integer pageSize;

    @ApiModelProperty(value = "列表")
    private List<ContentEntity> list;

}
