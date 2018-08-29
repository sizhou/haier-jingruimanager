package com.haier.service;

import com.haier.base.RespResult;
import com.haier.controller.po.ContentAddReq;
import com.haier.controller.po.ContentForTypeResp;
import com.haier.model.ContentEntity;
import com.haier.po.ContentEntityPo;

public interface ContentService {

   RespResult addNewContent(ContentAddReq contentAddReq);

   RespResult delContentByVersion(Long version);

   RespResult updContentByVersion(ContentAddReq updEn,Long version);

   RespResult findContentByVersion(Long version);

   RespResult findContentsBy(ContentEntityPo findEn);

   RespResult findAllTypeForCity(String city,String entryTime);

   RespResult<ContentForTypeResp> findAllForType(String city,String entryTime,Integer type,Long moduleId);

   RespResult listCategory(Integer categoryType);

}
