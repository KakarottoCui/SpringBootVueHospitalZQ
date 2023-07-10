package com.ivo.mas.service;

import com.ivo.mas.mapper.NmInfoMapper;
import com.ivo.mas.pojo.NmInfo;

import com.ivo.mas.system.ResponseFormat.ResponseResult;
import com.ivo.mas.system.ResponseFormat.ResponseCode;
import com.ivo.mas.system.utils.SessionUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;

@Service
public class NmInfoService {

    @Resource
    private NmInfoMapper nmInfoMapper;
    
    /**
     * 查询多条数据
     *
     * @param nmInfo 查询条件
     * @return 对象列表
     */
    public ResponseResult<Object> queryNmInfoList(NmInfo nmInfo) {
        String title = "";
        title = nmInfo.getTitle();
        if(title!=null){
            nmInfo.setTitle(null);
        }
        QueryWrapper<NmInfo> queryWrapper = new QueryWrapper<NmInfo>(nmInfo);
        if(title!=null)
            queryWrapper.like("title",title);
        return new ResponseResult<Object>(ResponseCode.SUCCESS,"查询成功",nmInfoMapper.selectList(queryWrapper));
    }
    
    /**
     * 查询一条数据
     *
     * @param nmInfo 查询条件
     * @return 对象
     */
    public ResponseResult<Object> queryNmInfoObject(NmInfo nmInfo) {
        QueryWrapper<NmInfo> queryWrapper = new QueryWrapper<NmInfo>(nmInfo);
        return new ResponseResult<Object>(ResponseCode.SUCCESS,"查询成功",nmInfoMapper.selectOne(queryWrapper));
    }
    
    /**
     * 新增一条数据
     *
     * @param nmInfo 新增数据实体类
     * @return 新增对象
     */
    public ResponseResult<Object> addNmInfo(NmInfo nmInfo) {
        int uid = SessionUtils.getUserId();
        nmInfo.setId(null);
        nmInfo.setValidFlag(1);
        nmInfo.setCreateTime(new Date());
        nmInfo.setUpdateTime(new Date());
        nmInfo.setCreater(uid);
        nmInfo.setUpdater(uid);
        nmInfoMapper.insert(nmInfo);
        return new ResponseResult<Object>(ResponseCode.SUCCESS,"新增成功",nmInfo);
    }
    
    /**
     * 修改一条数据
     *
     * @param nmInfo 修改数据实体类
     * @return 修改后对象
     */
    public ResponseResult<Object> editNmInfo(NmInfo nmInfo) {
        int uid = SessionUtils.getUserId();
        nmInfo.setUpdateTime(new Date());
        nmInfo.setUpdater(uid);
        nmInfoMapper.updateById(nmInfo);
        return new ResponseResult<Object>(ResponseCode.SUCCESS,"修改成功",nmInfo);
    }

}
