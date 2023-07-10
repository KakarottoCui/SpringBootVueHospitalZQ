package com.ivo.mas.mapper;

import com.ivo.mas.pojo.NmDrug;
import com.ivo.mas.pojo.NmRxItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 处方明细表(NmRxItem)表数据库访问层
 *
 */

@Repository
public interface NmRxItemMapper extends BaseMapper<NmRxItem> {

    @Select("SELECT r.id as 'rxId',d.* FROM nm_rx_item r RIGHT JOIN nm_drug d on r.drug_id = d.id  WHERE d.valid_flag = 1 and r.valid_flag = 1 and r.order_id  = #{orderId} ")
    List<NmDrug> getDrugByParam(@Param("orderId") Integer orderId);

}
