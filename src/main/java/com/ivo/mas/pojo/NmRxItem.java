package com.ivo.mas.pojo;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

/**
 * NmRxItem表实体类
 * 处方明细表
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NmRxItem implements Serializable {
    private static final long serialVersionUID = -88507357466802924L;

    /**
     * id,自增
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 药品id
     */    
    private Integer drugId;
    /**
     * 诊疗id
     */    
    private Integer orderId;
    /**
     * 价格
     */    
    private Float price;
    /**
     * 0无效，1有效
     */    
    private Integer validFlag;
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


}

