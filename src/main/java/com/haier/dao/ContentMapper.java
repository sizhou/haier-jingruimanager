package com.haier.dao;

import com.haier.controller.po.ContentPo;
import com.haier.model.CategoryEntity;
import com.haier.model.ContentEntity;
import com.haier.model.PeriodExplainEntity;
import com.haier.po.ContentEntityPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ContentMapper {

    int addNewContent(ContentEntity addEn);

    int updDelByVersion(@Param("version") Long version);

    int updVersionById(@Param("id") Long id);

    int updContentByVersion(@Param("updEn") ContentEntity updEn, @Param("version") Long version);

    ContentPo findSingleContentByVersion(@Param("version") Long version);

    List<ContentPo> findContentsBy(@Param("findEn") ContentEntityPo findEn);

    int countBy(@Param("findEn") ContentEntityPo findEn);

    List<CategoryEntity> listCategory(@Param("categoryType") Integer categoryType);

    //课程内容说明相关
    int addNewExplain(PeriodExplainEntity addEn);
    int updExplain(@Param("updEn") PeriodExplainEntity updEn, @Param("id") Long id);
    int delExplain(@Param("id") Long id);
}
