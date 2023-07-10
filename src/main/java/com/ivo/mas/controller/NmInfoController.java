package com.ivo.mas.controller;
import com.ivo.mas.service.NmInfoService;
import com.ivo.mas.pojo.NmInfo;
import com.ivo.mas.system.ResponseFormat.BaseResponse;
import com.ivo.mas.system.ResponseFormat.ResponseResult;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;

@Controller
@BaseResponse
@RequestMapping("/nmInfo")
public class NmInfoController {

    @Resource
    NmInfoService nmInfoService;
    
    /**
     * 查询多条数据
     *
     * @param nmInfo 查询条件
     * @return 对象列表
     */
    @RequestMapping("/queryList")
    @ResponseBody
    public ResponseResult<Object> queryNmInfoList(@RequestBody NmInfo nmInfo){
        return nmInfoService.queryNmInfoList(nmInfo);
    }
    /**
     * 查询一条数据
     *
     * @param nmInfo 查询条件
     * @return 对象
     */
    @RequestMapping("/queryObject")
    @ResponseBody
    public ResponseResult<Object> queryNmInfoObject(@RequestBody NmInfo nmInfo){
        return nmInfoService.queryNmInfoObject(nmInfo);
    }
    /**
     * 新增一条数据
     *
     * @param nmInfo 新增数据实体类
     * @return 新增对象
     */
    @RequestMapping("/addNmInfo")
    @ResponseBody
    public ResponseResult<Object> addNmInfo(@RequestBody NmInfo nmInfo){
        return nmInfoService.addNmInfo(nmInfo);
    }
    /**
     * 修改一条数据
     *
     * @param nmInfo 修改数据实体类
     * @return 修改后对象
     */
    @RequestMapping("/editNmInfo")
    @ResponseBody
    public ResponseResult<Object> editNmInfo(@RequestBody NmInfo nmInfo){
        return nmInfoService.editNmInfo(nmInfo);
    }
    
}
