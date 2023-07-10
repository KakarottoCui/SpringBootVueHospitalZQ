package com.ivo.mas.service;

import com.ivo.mas.mapper.NmHospSubMapper;
import com.ivo.mas.mapper.SysUserMapper;
import com.ivo.mas.pojo.NmHospSub;
import com.ivo.mas.pojo.SysUser;

import com.ivo.mas.system.ResponseFormat.ResponseResult;
import com.ivo.mas.system.ResponseFormat.ResponseCode;
import com.ivo.mas.system.utils.CommonFunction;
import com.ivo.mas.system.utils.SessionUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ivo.mas.system.utils.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private NmHospSubMapper nmHospSubMapper;
    /**
     * 查询多条数据
     *
     * @param sysUser 查询条件
     * @return 对象列表
     */
    public ResponseResult<Object> querySysUserList(SysUser sysUser) {
        String nickName = "";
        nickName = sysUser.getNickName();
        if(nickName!=null){
            sysUser.setNickName(null);
        }
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>(sysUser);
        if(nickName!=null)
            queryWrapper.like("nick_name",nickName);
        queryWrapper.orderByDesc("uid");
        List<SysUser> sysUserList = sysUserMapper.selectList(queryWrapper);
        for(SysUser user:sysUserList){
            if(user.getType()==2){
                user.setNmHospSub(nmHospSubMapper.selectById(user.getSub()));
            }
        }
        return new ResponseResult<Object>(ResponseCode.SUCCESS,"查询成功",sysUserList);
    }
    
    /**
     * 查询一条数据
     *
     * @param sysUser 查询条件
     * @return 对象
     */
    public ResponseResult<Object> querySysUserObject(SysUser sysUser) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>(sysUser);
        SysUser user = sysUserMapper.selectOne(queryWrapper);
        if(user.getType()==2){
            user.setNmHospSub(nmHospSubMapper.selectById(sysUser.getSub()));
        }
        return new ResponseResult<Object>(ResponseCode.SUCCESS,"查询成功",user);
    }
    
    /**
     * 新增一条数据
     *
     * @param sysUser 新增数据实体类
     * @return 新增对象
     */
    public ResponseResult<Object> addSysUser(SysUser sysUser) {
        Integer uid = SessionUtils.getUserId();
        sysUser.setUid(null);
        sysUser.setValidFlag(1);
        sysUser.setCreateTime(new Date());
        sysUser.setUpdateTime(new Date());
        sysUser.setCreater(uid);
        sysUser.setUpdater(uid);
        setPic(sysUser);
        sysUserMapper.insert(sysUser);
        return new ResponseResult<Object>(ResponseCode.SUCCESS,"新增成功",sysUser);
    }
    
    /**
     * 修改一条数据
     *
     * @param sysUser 修改数据实体类
     * @return 修改后对象
     */
    public ResponseResult<Object> editSysUser(SysUser sysUser) {
        Integer uid = SessionUtils.getUserId();
        sysUser.setUpdateTime(new Date());
        sysUser.setUpdater(uid);
        setPic(sysUser);
        sysUserMapper.updateById(sysUser);
        return new ResponseResult<Object>(ResponseCode.SUCCESS,"修改成功",sysUser);
    }

    public void setPic(SysUser nmBook){
        if(StringUtils.isNotEmpty(nmBook.getPic()) && nmBook.getPic().length()>100 ){
            String fileName = CommonFunction.SaveBase64Pic(nmBook.getPic());
            nmBook.setPic(fileName);
        }
    }

}
