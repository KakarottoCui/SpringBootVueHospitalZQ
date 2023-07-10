package com.ivo.mas.service;

import com.ivo.mas.mapper.NmHospSubMapper;
import com.ivo.mas.pojo.NmHospSub;

import com.ivo.mas.pojo.NmInfo;
import com.ivo.mas.system.ResponseFormat.ResponseResult;
import com.ivo.mas.system.ResponseFormat.ResponseCode;
import com.ivo.mas.system.utils.SessionUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;

@Service
public class NmHospSubService {

    @Resource
    private NmHospSubMapper nmHospSubMapper;
    
    /**
     * 查询多条数据
     *
     * @param nmHospSub 查询条件
     * @return 对象列表
     */
    public ResponseResult<Object> queryNmHospSubList(NmHospSub nmHospSub) {
        QueryWrapper<NmHospSub> queryWrapper = new QueryWrapper<NmHospSub>(nmHospSub);
        return new ResponseResult<Object>(ResponseCode.SUCCESS,"查询成功",nmHospSubMapper.selectList(queryWrapper));
    }
    
    /**
     * 查询一条数据
     *
     * @param nmHospSub 查询条件
     * @return 对象
     */
    public ResponseResult<Object> queryNmHospSubObject(NmHospSub nmHospSub) {
        QueryWrapper<NmHospSub> queryWrapper = new QueryWrapper<NmHospSub>(nmHospSub);
        return new ResponseResult<Object>(ResponseCode.SUCCESS,"查询成功",nmHospSubMapper.selectOne(queryWrapper));
    }
    
    /**
     * 新增一条数据
     *
     * @param nmHospSub 新增数据实体类
     * @return 新增对象
     */
    public ResponseResult<Object> addNmHospSub(NmHospSub nmHospSub) {
        int uid = SessionUtils.getUserId();
        nmHospSub.setId(null);
        nmHospSub.setValidFlag(1);
        nmHospSub.setCreateTime(new Date());
        nmHospSub.setUpdateTime(new Date());
        nmHospSub.setCreater(uid);
        nmHospSub.setUpdater(uid);
        nmHospSubMapper.insert(nmHospSub);
        return new ResponseResult<Object>(ResponseCode.SUCCESS,"新增成功",nmHospSub);
    }
    
    /**
     * 修改一条数据
     *
     * @param nmHospSub 修改数据实体类
     * @return 修改后对象
     */
    public ResponseResult<Object> editNmHospSub(NmHospSub nmHospSub) {
        int uid = SessionUtils.getUserId();
        nmHospSub.setUpdateTime(new Date());
        nmHospSub.setUpdater(uid);
        nmHospSubMapper.updateById(nmHospSub);
        return new ResponseResult<Object>(ResponseCode.SUCCESS,"修改成功",nmHospSub);
    }

}
