package com.ivo.mas.service;

import com.ivo.mas.mapper.NmRxItemMapper;
import com.ivo.mas.pojo.NmRxItem;

import com.ivo.mas.system.ResponseFormat.ResponseResult;
import com.ivo.mas.system.ResponseFormat.ResponseCode;
import com.ivo.mas.system.utils.SessionUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;

@Service
public class NmRxItemService {

    @Resource
    private NmRxItemMapper nmRxItemMapper;
    
    /**
     * 查询多条数据
     *
     * @param nmRxItem 查询条件
     * @return 对象列表
     */
    public ResponseResult<Object> queryNmRxItemList(NmRxItem nmRxItem) {
        QueryWrapper<NmRxItem> queryWrapper = new QueryWrapper<NmRxItem>(nmRxItem);
        return new ResponseResult<Object>(ResponseCode.SUCCESS,"查询成功",nmRxItemMapper.selectList(queryWrapper));
    }
    
    /**
     * 查询一条数据
     *
     * @param nmRxItem 查询条件
     * @return 对象
     */
    public ResponseResult<Object> queryNmRxItemObject(NmRxItem nmRxItem) {
        QueryWrapper<NmRxItem> queryWrapper = new QueryWrapper<NmRxItem>(nmRxItem);
        return new ResponseResult<Object>(ResponseCode.SUCCESS,"查询成功",nmRxItemMapper.selectOne(queryWrapper));
    }
    
    /**
     * 新增一条数据
     *
     * @param nmRxItem 新增数据实体类
     * @return 新增对象
     */
    public ResponseResult<Object> addNmRxItem(NmRxItem nmRxItem) {
        int uid = SessionUtils.getUserId();
        nmRxItem.setId(null);
        nmRxItem.setValidFlag(1);
        nmRxItem.setCreateTime(new Date());
        nmRxItem.setUpdateTime(new Date());
        nmRxItem.setCreater(uid);
        nmRxItem.setUpdater(uid);
        nmRxItemMapper.insert(nmRxItem);
        return new ResponseResult<Object>(ResponseCode.SUCCESS,"新增成功",nmRxItem);
    }
    
    /**
     * 修改一条数据
     *
     * @param nmRxItem 修改数据实体类
     * @return 修改后对象
     */
    public ResponseResult<Object> editNmRxItem(NmRxItem nmRxItem) {
        int uid = SessionUtils.getUserId();
        nmRxItem.setUpdateTime(new Date());
        nmRxItem.setUpdater(uid);
        nmRxItemMapper.updateById(nmRxItem);
        return new ResponseResult<Object>(ResponseCode.SUCCESS,"修改成功",nmRxItem);
    }

}
