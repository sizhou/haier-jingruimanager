package com.haier.po;

import com.haier.model.ContentEntity;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ContentEntityPo extends ContentEntity {
    private String searchAttr;//模糊搜索条件

    private String orderClause;//排序


    private Integer pageSize;

    private Integer pageNo;

    private Integer startRow;


}
