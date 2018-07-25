package com.haier.service;

import com.haier.base.RespResult;
import com.haier.model.ContentEntity;
import com.haier.po.ContentEntityPo;

public interface ContentService {

   RespResult addNewContent(ContentEntity contentEntity);

   RespResult delContentById(Long id);

   RespResult updContentById(ContentEntity updEn,Long id);

   RespResult findContentById(Long id);

   RespResult findContentsBy(ContentEntityPo findEn);

   RespResult findAllTypeForCity(String city,String entryTime);

}
