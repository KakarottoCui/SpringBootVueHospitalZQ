package com.ivo.mas.controller;
import com.ivo.mas.service.NmOrderService;
import com.ivo.mas.pojo.NmOrder;
import com.ivo.mas.system.ResponseFormat.BaseResponse;
import com.ivo.mas.system.ResponseFormat.ResponseResult;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;

@Controller
@BaseResponse
@RequestMapping("/nmOrder")
public class NmOrderController {

    @Resource
    NmOrderService nmOrderService;
    
    /**
     * 查询多条数据
     *
     * @param nmOrder 查询条件
     * @return 对象列表
     */
    @RequestMapping("/queryList")
    @ResponseBody
    public ResponseResult<Object> queryNmOrderList(@RequestBody NmOrder nmOrder){
        return nmOrderService.queryNmOrderList(nmOrder);
    }
    /**
     * 查询一条数据
     *
     * @param nmOrder 查询条件
     * @return 对象
     */
    @RequestMapping("/queryObject")
    @ResponseBody
    public ResponseResult<Object> queryNmOrderObject(@RequestBody NmOrder nmOrder){
        return nmOrderService.queryNmOrderObject(nmOrder);
    }
    /**
     * 新增一条数据
     *
     * @param nmOrder 新增数据实体类
     * @return 新增对象
     */
    @RequestMapping("/addNmOrder")
    @ResponseBody
    public ResponseResult<Object> addNmOrder(@RequestBody NmOrder nmOrder){
        return nmOrderService.addNmOrder(nmOrder);
    }
    /**
     * 修改一条数据
     *
     * @param nmOrder 修改数据实体类
     * @return 修改后对象
     */
    @RequestMapping("/editNmOrder")
    @ResponseBody
    public ResponseResult<Object> editNmOrder(@RequestBody NmOrder nmOrder){
        return nmOrderService.editNmOrder(nmOrder);
    }
    
}
