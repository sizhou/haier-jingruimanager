package com.haier.dao;

import com.haier.model.CategoryEntity;
import com.haier.model.ContentEntity;
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

    ContentEntity findSingleContentByVersion(@Param("version") Long version);

    List<ContentEntity> findContentsBy(@Param("findEn") ContentEntityPo findEn);

    int countBy(@Param("findEn") ContentEntityPo findEn);

    List<CategoryEntity> listCategory(@Param("categoryType") Integer categoryType);

}
