package com.haier.dao;

import com.haier.model.ContentEntity;
import com.haier.po.ContentEntityPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ContentMapper {

    int addNewContent(@Param("addEn") ContentEntity addEn);

    int updDelById(@Param("id") Long id);

    int updContentById(@Param("updEn") ContentEntity updEn, @Param("id") Long id);

    ContentEntity findSingleContentById(@Param("id") Long id);

    List<ContentEntity> findContentsBy(@Param("findEn") ContentEntityPo findEn);

    int countBy(@Param("findEn") ContentEntityPo findEn);

}
