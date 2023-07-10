package com.ivo.mas.pojo;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

/**
 * NmInfo表实体类
 * 公告表
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NmInfo implements Serializable {
    private static final long serialVersionUID = 474579224324066526L;

    /**
     * id,自增
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 标题
     */    
    private String title;
    /**
     * 类别，1简介，2指南，0公告
     */    
    private Integer type;
    /**
     * 内容
     */    
    private String content;
    /**
     * 创建人id
     */    
    private Integer creater;
    /**
     * 更新人id
     */    
    private Integer updater;
    /**
     * 创建时间
     */    
    private Date createTime;
    /**
     * 更新时间
     */    
    private Date updateTime;
    /**
     * 备注
     */    
    private String memo;
    /**
     * 有效标识，1有效，0无效
     */    
    private Integer validFlag;


}

