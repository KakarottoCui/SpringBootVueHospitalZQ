package com.ivo.mas.controller;
import com.ivo.mas.service.NmRxItemService;
import com.ivo.mas.pojo.NmRxItem;
import com.ivo.mas.system.ResponseFormat.BaseResponse;
import com.ivo.mas.system.ResponseFormat.ResponseResult;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;

@Controller
@BaseResponse
@RequestMapping("/nmRxItem")
public class NmRxItemController {

    @Resource
    NmRxItemService nmRxItemService;
    
    /**
     * 查询多条数据
     *
     * @param nmRxItem 查询条件
     * @return 对象列表
     */
    @RequestMapping("/queryList")
    @ResponseBody
    public ResponseResult<Object> queryNmRxItemList(@RequestBody NmRxItem nmRxItem){
        return nmRxItemService.queryNmRxItemList(nmRxItem);
    }
    /**
     * 查询一条数据
     *
     * @param nmRxItem 查询条件
     * @return 对象
     */
    @RequestMapping("/queryObject")
    @ResponseBody
    public ResponseResult<Object> queryNmRxItemObject(@RequestBody NmRxItem nmRxItem){
        return nmRxItemService.queryNmRxItemObject(nmRxItem);
    }
    /**
     * 新增一条数据
     *
     * @param nmRxItem 新增数据实体类
     * @return 新增对象
     */
    @RequestMapping("/addNmRxItem")
    @ResponseBody
    public ResponseResult<Object> addNmRxItem(@RequestBody NmRxItem nmRxItem){
        return nmRxItemService.addNmRxItem(nmRxItem);
    }
    /**
     * 修改一条数据
     *
     * @param nmRxItem 修改数据实体类
     * @return 修改后对象
     */
    @RequestMapping("/editNmRxItem")
    @ResponseBody
    public ResponseResult<Object> editNmRxItem(@RequestBody NmRxItem nmRxItem){
        return nmRxItemService.editNmRxItem(nmRxItem);
    }
    
}
