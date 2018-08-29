package com.haier.controller;


import com.haier.base.IMRespEnum;
import com.haier.base.RespResult;
import com.haier.controller.po.ContentAddReq;
import com.haier.po.ContentEntityPo;
import com.haier.service.ContentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Objects;

@Api(tags = "内容录入管理")
@RestController
@RequestMapping(value = "content")
public class ContentController {

    @Autowired
    private ContentService contentService;


    @ApiOperation(value = "添加内容信息", httpMethod = "POST", notes = "添加内容信息")
    @ApiResponse(code = 200, message = "success", response = RespResult.class)
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public RespResult addModuleItem(
            @ApiParam(value = "模块类型，1：大事记，2：价目表,3:特色课程", required = true) @RequestParam("moduleId") Long moduleId,
            @ApiParam(value = "城市", required = true) @RequestParam(required = true, name = "city") String city,
            @ApiParam(value = "时间", required = false) @RequestParam(required = false, name = "entryTime") String entryTime,
            @ApiParam(value = "内容类型", required = true, defaultValue = "1") @RequestParam(required = true, name = "type") Integer type,
            @ApiParam(value = "内容详情", required = true) @RequestParam(required = true, name = "content") String content,
            @ApiParam(value = "备注", required = false) @RequestParam(required = false, name = "remark") String remark,
            @ApiParam(value = "类别", required = true) @RequestParam(required = true, name = "categoryId") Long categoryId,
            @ApiParam(value = "生效时间段", required = false) @RequestParam(required = false, name = "effectTime") String effectTime,
            @ApiParam(value = "课程有效时间段", required = false) @RequestParam(required = false, name = "validTime") String validTime,
            @ApiParam(value = "最高课时", required = false) @RequestParam(required = false, name = "maxPeriod") Integer maxPeriod,
            @ApiParam(value = "封顶课时", required = false) @RequestParam(required = false, name = "cappingPeriod") Integer cappingPeriod
            ) {
        RespResult respResult = new RespResult();
        ContentAddReq addEn = new ContentAddReq();
        addEn.setModuleId(moduleId).setCity(city).setEntryTime(entryTime)
                .setType(type).setContent(content).setRemark(remark).setCategoryId(categoryId)
                .setEffectTime(effectTime).setValidTime(validTime)
                .setMaxPeriod(maxPeriod).setCappingPeriod(cappingPeriod);
        if (Objects.nonNull(addEn)) {
            return contentService.addNewContent(addEn);
        } else {
            respResult.setCode(IMRespEnum.PARAM_ERROR.getCode());
            respResult.setMsg(IMRespEnum.PARAM_ERROR.getMsg());
        }
        return respResult;
    }

    @ApiOperation(value = "修改模块信息", httpMethod = "POST", notes = "修改模块信息")
    @ApiResponse(code = 200, message = "success", response = RespResult.class)
    @RequestMapping(value = "/upd", method = RequestMethod.POST)
    public RespResult updModuleItem(
            @ApiParam(value = "version", required = true) @RequestParam(required = true, name = "version") Long version,
            @ApiParam(value = "城市", required = false) @RequestParam(required = false, name = "city") String city,
            @ApiParam(value = "时间", required = false) @RequestParam(required = false, name = "entryTime") String entryTime,
            @ApiParam(value = "内容类型", required = false, defaultValue = "1") @RequestParam(required = false, name = "type") Integer type,
            @ApiParam(value = "内容详情", required = false) @RequestParam(required = false, name = "content") String content,
            @ApiParam(value = "备注", required = false) @RequestParam(required = false, name = "remark") String remark,
            @ApiParam(value = "类别", required = true) @RequestParam(required = false, name = "categoryId") Long categoryId,
            @ApiParam(value = "生效时间段", required = false) @RequestParam(required = false, name = "effectTime") String effectTime,
            @ApiParam(value = "课程有效时间段", required = false) @RequestParam(required = false, name = "validTime") String validTime,
            @ApiParam(value = "最高课时", required = false) @RequestParam(required = false, name = "maxPeriod") Integer maxPeriod,
            @ApiParam(value = "封顶课时", required = false) @RequestParam(required = false, name = "cappingPeriod") Integer cappingPeriod) {
        RespResult respResult = new RespResult();
        ContentAddReq updEn = new ContentAddReq();
        updEn.setCity(city).setEntryTime(entryTime)
                .setType(type).setContent(content).setRemark(remark).setCategoryId(categoryId)
                .setEffectTime(effectTime).setValidTime(validTime)
                .setMaxPeriod(maxPeriod).setCappingPeriod(cappingPeriod);
        if (Objects.nonNull(updEn) && version != null && version > 0) {
            return contentService.updContentByVersion(updEn, version);
        } else {
            respResult.setCode(IMRespEnum.PARAM_ERROR.getCode());
            respResult.setMsg(IMRespEnum.PARAM_ERROR.getMsg());
        }
        return respResult;
    }


    @ApiOperation(value = "删除内容信息", httpMethod = "DELETE", notes = "删除模块信息")
    @ApiResponse(code = 200, message = "success", response = RespResult.class)
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public RespResult delModuleItem(@RequestParam Long version) {
        RespResult respResult = new RespResult();
        if (Objects.nonNull(version)) {
            respResult = contentService.delContentByVersion(version);
        } else {
            respResult.setCode(IMRespEnum.PARAM_ERROR.getCode());
            respResult.setMsg(IMRespEnum.PARAM_ERROR.getMsg());
        }
        return respResult;
    }


    @ApiOperation(value = "内容详情", httpMethod = "GET", notes = "模块详情")
    @ApiResponse(code = 200, message = "success", response = RespResult.class)
    @RequestMapping(value = "/findByVersion", method = RequestMethod.GET)
    public RespResult findItemById(@ApiParam(value = "version", required = true) @RequestParam(name = "version", required = true) Long version) {
        RespResult respResult = new RespResult();
        if (Objects.nonNull(version) && version > 0) {
            respResult = contentService.findContentByVersion(version);
        } else {
            respResult.setCode(IMRespEnum.PARAM_ERROR.getCode());
            respResult.setMsg(IMRespEnum.PARAM_ERROR.getMsg());
        }
        return respResult;
    }

    @ApiOperation(value = "城市的所有最新类型数据", httpMethod = "GET", notes = "城市数据")
    @ApiResponse(code = 200, message = "success", response = RespResult.class)
    @RequestMapping(value = "/list/Forcity", method = RequestMethod.GET)
    public RespResult findItemById(
            @ApiParam(value = "录入时间", required = false) @RequestParam(name = "entryTime", required = false) String entryTime,
            @ApiParam(value = "城市", required = false) @RequestParam(name = "city", required = false) String city
            ) {
        RespResult respResult = new RespResult();
        if (Objects.nonNull(city) && StringUtils.isNotEmpty(city.trim())) {
            respResult = contentService.findAllTypeForCity(city,entryTime);
        } else {
            respResult.setCode(IMRespEnum.PARAM_ERROR.getCode());
            respResult.setMsg(IMRespEnum.PARAM_ERROR.getMsg());
        }
        return respResult;
    }



    @ApiOperation(value = "根据type获取的所有最新类型数据", httpMethod = "GET", notes = "内容数据")
    @ApiResponse(code = 200, message = "success", response = RespResult.class)
    @RequestMapping(value = "/list/Fortype", method = RequestMethod.GET)
    public RespResult findItemByType(
            @ApiParam(value = "录入时间", required = false) @RequestParam(name = "entryTime", required = false) String entryTime,
            @ApiParam(value = "城市", required = false) @RequestParam(name = "city", required = false) String city,
            @ApiParam(value = "moduleId", required = true) @RequestParam(name = "moduleId", required = false) Long moduleId,
            @ApiParam(value = "type", required = true) @RequestParam(name = "type", required = false) Integer type
    ) {
        RespResult respResult = new RespResult();
        if (Objects.nonNull(type) && type > 0) {
            respResult = contentService.findAllForType(city,entryTime,type,moduleId);
        } else {
            respResult.setCode(IMRespEnum.PARAM_ERROR.getCode());
            respResult.setMsg(IMRespEnum.PARAM_ERROR.getMsg());
        }
        return respResult;
    }


    @ApiOperation(value = "模块上下线", httpMethod = "POST", notes = "模块上下线")
    @ApiResponse(code = 200, message = "success", response = RespResult.class)
    @RequestMapping(value = "/changeStatus", method = RequestMethod.POST)
    public RespResult changeStatus(@ApiParam(value = "version", required = true) @RequestParam(name = "version", required = true) Long version,
                                   @ApiParam(value = "状态，1：上线，2：下线", required = true) @RequestParam(name = "status", required = true) Integer status) {
        RespResult respResult = new RespResult();
        if (Objects.nonNull(version) && version > 0) {
            if (status.equals(1) || status.equals(2)) {
                ContentAddReq updEn = new ContentAddReq();
                updEn.setStatus(status);
                respResult = contentService.updContentByVersion(updEn, version);
            } else {
                respResult.setMsg(IMRespEnum.PARAM_ERROR_MoDULE_STATUS.getMsg());
                respResult.setCode(IMRespEnum.PARAM_ERROR_MoDULE_STATUS.getCode());
            }
        }
        return respResult;
    }


    @ApiOperation(value = "内容模糊查询", httpMethod = "GET", notes = "模糊查询")
    @ApiResponse(code = 200, message = "success", response = RespResult.class)
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public RespResult findItemById(
            @ApiParam(value = "模糊查询搜索条件", required = false) @RequestParam(name = "searchAttr", required = false) String searchAttr,
            @ApiParam(value = "模块状态(1:上线，2：下线，3：删除)", required = false) @RequestParam(name = "status", required = false) Integer status,
            @ApiParam(value = "moduleId", required = true) @RequestParam(name = "moduleId", required = true) Long moduleId,
            @ApiParam(value = "页码", required = true) @RequestParam(name = "pageNo") Integer pageNo,
            @ApiParam(value = "每页长度", required = true) @RequestParam(name = "pageSize") Integer pageSize) {
        RespResult respResult = new RespResult();
        if (null == pageNo || pageNo <= 0) {
            pageNo = 1;
        }
        if (null == pageSize || pageSize <= 0) {
            pageSize = 10;
        }
        if (status == null || status.equals(1) || status.equals(2) || status.equals(3)) {
            ContentEntityPo findEn = new ContentEntityPo();
            if (searchAttr != null && StringUtils.isNotEmpty(searchAttr.trim())) {
                searchAttr = "%" + searchAttr + "%";
                findEn.setSearchAttr(searchAttr);
            }
            Integer startIndex = pageSize * (pageNo - 1);
            findEn.setPageSize(pageSize);
            findEn.setStartRow(startIndex);
            findEn.setPageNo(pageNo);
            findEn.setModuleId(moduleId);
            findEn.setStatus(status);
            findEn.setOrderClause(" createdTime DESC ");

            respResult = contentService.findContentsBy(findEn);
        } else {
            respResult.setMsg(IMRespEnum.PARAM_ERROR_MoDULE_STATUS.getMsg());
            respResult.setCode(IMRespEnum.PARAM_ERROR_MoDULE_STATUS.getCode());
        }
        return respResult;
    }


    @ApiOperation(value = "类别list", httpMethod = "GET", notes = "类别")
    @ApiResponse(code = 200, message = "success", response = RespResult.class)
    @RequestMapping(value = "/list/category", method = RequestMethod.GET)
    public RespResult listCategory( @ApiParam(value = "类别类型", required = false) @RequestParam(name = "categoryType", required = false) Integer categoryType
    ) {
       return contentService.listCategory(categoryType);
    }


}


