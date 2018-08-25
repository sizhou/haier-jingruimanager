package com.haier.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.haier.base.IMRespEnum;
import com.haier.base.RespResult;
import com.haier.controller.po.ContentForCityResp;
import com.haier.controller.po.ContentListResp;
import com.haier.dao.ContentMapper;
import com.haier.model.ContentEntity;
import com.haier.po.ContentEntityPo;
import com.haier.service.ContentService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class ContentServiceImpl implements ContentService {

    @Resource
    private ContentMapper contentMapper;


    @Override
    public RespResult addNewContent(ContentEntity contentEntity) {
        RespResult respResult = new RespResult();
        contentEntity.setCreatedTime(new Date());
        int result = contentMapper.addNewContent(contentEntity);
        if (result > 0) {
            respResult.setCode(IMRespEnum.SUCCESS.getCode());
            respResult.setMsg(IMRespEnum.SUCCESS.getMsg());
        } else {
            respResult.setCode(IMRespEnum.FAIL.getCode());
            respResult.setMsg(IMRespEnum.FAIL.getMsg());
        }
        return respResult;
    }

    @Override
    public RespResult delContentById(Long id) {
        RespResult respResult = new RespResult();
        int result = contentMapper.updDelById(id);
        if (result > 0) {
            respResult.setCode(IMRespEnum.SUCCESS.getCode());
            respResult.setMsg(IMRespEnum.SUCCESS.getMsg());
        } else {
            respResult.setCode(IMRespEnum.FAIL.getCode());
            respResult.setMsg(IMRespEnum.FAIL.getMsg());
        }
        return respResult;
    }

    @Override
    public RespResult updContentById(ContentEntity updEn, Long id) {
        RespResult respResult = new RespResult();
        updEn.setUpdatedTime(new Date());
        int result = contentMapper.updContentById(updEn, id);
        if (result > 0) {
            respResult.setCode(IMRespEnum.SUCCESS.getCode());
            respResult.setMsg(IMRespEnum.SUCCESS.getMsg());
        } else {
            respResult.setCode(IMRespEnum.FAIL.getCode());
            respResult.setMsg(IMRespEnum.FAIL.getMsg());
        }
        return respResult;
    }

    @Override
    public RespResult findContentById(Long id) {
        RespResult respResult = new RespResult();
        ContentEntity contentEntity = contentMapper.findSingleContentById(id);
        respResult.setData(contentEntity);
        respResult.setCode(IMRespEnum.SUCCESS.getCode());
        respResult.setMsg(IMRespEnum.SUCCESS.getMsg());
        return respResult;
    }

    @Override
    public RespResult findContentsBy(ContentEntityPo findEn) {
        RespResult respResult = new RespResult();
        if (null != findEn && null != findEn.getStatus() && findEn.getStatus() > 0) {
            Integer status = findEn.getStatus();
            if (1 == status) {
                findEn.setStatus(1).setIsDelete(false);
            } else if (2 == status) {
                findEn.setStatus(2).setIsDelete(false);
            } else if (3 == status) {
                findEn.setStatus(null).setIsDelete(true);
            } else {
                findEn.setStatus(null).setIsDelete(null);
            }
        }
        List<ContentEntity> list = contentMapper.findContentsBy(findEn);
        list.stream().forEach(c -> {
//            System.out.println(c.getIsDelete());
            if (Objects.nonNull(c.getIsDelete()) && c.getIsDelete()) {
                c.setStatus(3);
            }
        });
        int totalCount = contentMapper.countBy(findEn);
        ContentListResp resp = new ContentListResp();
        resp.setPageNo(findEn.getPageNo());
        resp.setPageSize(findEn.getPageSize());
        resp.setTotal(totalCount);
        resp.setList(list);
        respResult.setData(resp);
        respResult.setCode(IMRespEnum.SUCCESS.getCode());
        respResult.setMsg(IMRespEnum.SUCCESS.getMsg());
        return respResult;
    }


    @Override
    public RespResult findAllTypeForCity(String city, String entryTime) {
        RespResult respResult = new RespResult();
        ContentEntityPo findEn = new ContentEntityPo();
        findEn.setCity(city);
        findEn.setOrderClause("entry_time");
        if (null != entryTime || StringUtils.isNotEmpty(entryTime)) {
            findEn.setEntryTime(entryTime);
        }
        findEn.setStatus(1);
        findEn.setIsDelete(false);
        List<ContentEntity> list = contentMapper.findContentsBy(findEn);
        ContentForCityResp resultData = null;
        List<ContentEntity> typeList;
        Map<Integer, ContentEntity> typeMap = Maps.newLinkedHashMap();
        if (null != list && list.size() > 0) {
            resultData = new ContentForCityResp();
            resultData.setCity(city);
            typeList = Lists.newArrayList();
            for (ContentEntity en : list) {
                typeMap.put(en.getType(), en);
            }
            if (typeMap != null) {
                if (typeMap.containsKey(1)) {
                    typeList.add(typeMap.get(1));
                }
                if (typeMap.containsKey(2)) {
                    typeList.add(typeMap.get(2));
                }
                if (typeMap.containsKey(3)) {
                    typeList.add(typeMap.get(3));
                }
                if (typeMap.containsKey(4)) {
                    typeList.add(typeMap.get(4));
                }
                resultData.setTypeList(typeList);
            }

        }
        respResult.setData(resultData);
        respResult.setCode(IMRespEnum.SUCCESS.getCode());
        respResult.setMsg(IMRespEnum.SUCCESS.getMsg());
        return respResult;
    }
}
