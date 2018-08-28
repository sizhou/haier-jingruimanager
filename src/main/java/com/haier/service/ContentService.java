package com.haier.service;

import com.haier.base.RespResult;
import com.haier.controller.po.ContentForTypeResp;
import com.haier.model.ContentEntity;
import com.haier.po.ContentEntityPo;

public interface ContentService {

   RespResult addNewContent(ContentEntity contentEntity);

   RespResult delContentByVersion(Long version);

   RespResult updContentByVersion(ContentEntity updEn,Long version);

   RespResult findContentByVersion(Long version);

   RespResult findContentsBy(ContentEntityPo findEn);

   RespResult findAllTypeForCity(String city,String entryTime);

   RespResult<ContentForTypeResp> findAllForType(String city,String entryTime,Integer type);

   RespResult listCategory(Integer categoryType);

}
