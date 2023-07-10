package com.ivo.mas.service;

import com.ivo.mas.mapper.*;
import com.ivo.mas.pojo.NmDrug;
import com.ivo.mas.pojo.NmOrder;

import com.ivo.mas.system.ResponseFormat.ResponseResult;
import com.ivo.mas.system.ResponseFormat.ResponseCode;
import com.ivo.mas.system.utils.SessionUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class NmOrderService {

    @Resource
    private NmOrderMapper nmOrderMapper;
    @Resource
    private NmHospSubMapper nmHospSubMapper;
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private NmDrugMapper drugMapper;
    @Resource
    private NmRxItemMapper nmRxItemMapper;
    
    /**
     * 查询多条数据
     *
     * @param nmOrder 查询条件
     * @return 对象列表
     */
    public ResponseResult<Object> queryNmOrderList(NmOrder nmOrder) {
        QueryWrapper<NmOrder> queryWrapper = new QueryWrapper<NmOrder>(nmOrder);
        List<NmOrder> orderList = nmOrderMapper.selectList(queryWrapper);
        for(NmOrder oneOrder:orderList){
            oneOrder.setNmHospSub(nmHospSubMapper.selectById(oneOrder.getSubId()));
            oneOrder.setDocter(sysUserMapper.selectById(oneOrder.getDocId()));
            oneOrder.setDrugList(nmRxItemMapper.getDrugByParam(oneOrder.getId()));
            oneOrder.setUser(sysUserMapper.selectById(oneOrder.getUserId()));
        }
        queryWrapper.orderByDesc("id");
        return new ResponseResult<Object>(ResponseCode.SUCCESS,"查询成功",orderList);
    }
    
    /**
     * 查询一条数据
     *
     * @param nmOrder 查询条件
     * @return 对象
     */
    public ResponseResult<Object> queryNmOrderObject(NmOrder nmOrder) {
        QueryWrapper<NmOrder> queryWrapper = new QueryWrapper<NmOrder>(nmOrder);
        return new ResponseResult<Object>(ResponseCode.SUCCESS,"查询成功",nmOrderMapper.selectOne(queryWrapper));
    }
    
    /**
     * 新增一条数据
     *
     * @param nmOrder 新增数据实体类
     * @return 新增对象
     */
    public ResponseResult<Object> addNmOrder(NmOrder nmOrder) {
        int uid = SessionUtils.getUserId();
        nmOrder.setId(null);
        nmOrder.setValidFlag(1);
        nmOrder.setCreateTime(new Date());
        nmOrder.setUpdateTime(new Date());
        nmOrder.setCreater(uid);
        nmOrder.setUpdater(uid);
        nmOrderMapper.insert(nmOrder);
        return new ResponseResult<Object>(ResponseCode.SUCCESS,"新增成功",nmOrder);
    }
    
    /**
     * 修改一条数据
     *
     * @param nmOrder 修改数据实体类
     * @return 修改后对象
     */
    public ResponseResult<Object> editNmOrder(NmOrder nmOrder) {
        int uid = SessionUtils.getUserId();
        nmOrder.setUpdateTime(new Date());
        nmOrder.setUpdater(uid);
        nmOrderMapper.updateById(nmOrder);
        return new ResponseResult<Object>(ResponseCode.SUCCESS,"修改成功",nmOrder);
    }

}
