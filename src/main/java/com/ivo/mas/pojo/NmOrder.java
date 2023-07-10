package com.ivo.mas.pojo;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

/**
 * NmOrder表实体类
 * 挂号诊疗表
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NmOrder implements Serializable {
    private static final long serialVersionUID = 129710168863753406L;

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
     * 0不住院,1住院
     */    
    private Integer type;
    /**
     * 备注
     */    
    private String memo;
    /**
     * 挂号时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm", timezone = "GMT+8")
    private Date orderTime;
    /**
     * 创建人id
     */    
    private Integer creater;
    /**
     * 创建时间
     */    
    private Date createTime;
    /**
     * 有效标识，0无效，1有效
     */    
    private Integer validFlag;
    /**
     * 更新人id
     */    
    private Integer updater;
    /**
     * 更新时间
     */    
    private Date updateTime;
    /**
     * 状态，0预约成功,1签到,2诊疗结束,3付费结束
     */    
    private Integer state;
    /**
     * 科室id
     */    
    private Integer subId;
    /**
     * 医生id
     */    
    private Integer docId;
    /**
     * 诊疗结果
     */    
    private String content;
    /**
     * 出院备注
     */    
    private String content2;
    /**
     * 处方备注
     */    
    private String content3;
    /**
     * 会诊标识，空为不会诊，非空为会诊专家
     */    
    private String mult;
    /**
     * 0不开处方，1开处方
     */    
    private Integer drug;
    /**
     * 0不转院，1转院
     */    
    private Integer move;
    /**
     * 转院明细
     */    
    private String moveMemo;
    /**
     * 结束时间
     */    
    private Date closeTime;
    /**
     * 挂号价格，默认普通号10,专家号30
     */    
    private Float orderPrice;
    /**
     * 药物价格
     */    
    private Float drugPrice;
    /**
     * 其他诊疗价格
     */    
    private Float otherPrice;
    /**
     * 患者id
     */
    private Integer userId;
    /**
     * 住院表示
     */
    private Integer stay;
    /**
     * 辅助检查
     */
    private String toolCheck;
    /**
     * 危险性评估
     */
    private String dangerCheck;


    @TableField(exist = false)
    private NmHospSub nmHospSub;

    @TableField(exist = false)
    private SysUser docter;

    @TableField(exist = false)
    private List<NmDrug> drugList;

    @TableField(exist = false)
    private SysUser user;

}

