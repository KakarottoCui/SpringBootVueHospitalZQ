package com.ivo.mas.controller;
import com.ivo.mas.service.NmHospSubService;
import com.ivo.mas.pojo.NmHospSub;
import com.ivo.mas.system.ResponseFormat.BaseResponse;
import com.ivo.mas.system.ResponseFormat.ResponseResult;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;

@Controller
@BaseResponse
@RequestMapping("/nmHospSub")
public class NmHospSubController {

    @Resource
    NmHospSubService nmHospSubService;
    
    /**
     * 查询多条数据
     *
     * @param nmHospSub 查询条件
     * @return 对象列表
     */
    @RequestMapping("/queryList")
    @ResponseBody
    public ResponseResult<Object> queryNmHospSubList(@RequestBody NmHospSub nmHospSub){
        return nmHospSubService.queryNmHospSubList(nmHospSub);
    }
    /**
     * 查询一条数据
     *
     * @param nmHospSub 查询条件
     * @return 对象
     */
    @RequestMapping("/queryObject")
    @ResponseBody
    public ResponseResult<Object> queryNmHospSubObject(@RequestBody NmHospSub nmHospSub){
        return nmHospSubService.queryNmHospSubObject(nmHospSub);
    }
    /**
     * 新增一条数据
     *
     * @param nmHospSub 新增数据实体类
     * @return 新增对象
     */
    @RequestMapping("/addNmHospSub")
    @ResponseBody
    public ResponseResult<Object> addNmHospSub(@RequestBody NmHospSub nmHospSub){
        return nmHospSubService.addNmHospSub(nmHospSub);
    }
    /**
     * 修改一条数据
     *
     * @param nmHospSub 修改数据实体类
     * @return 修改后对象
     */
    @RequestMapping("/editNmHospSub")
    @ResponseBody
    public ResponseResult<Object> editNmHospSub(@RequestBody NmHospSub nmHospSub){
        return nmHospSubService.editNmHospSub(nmHospSub);
    }
    
}
