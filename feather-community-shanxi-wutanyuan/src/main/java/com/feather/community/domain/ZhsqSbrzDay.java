package com.feather.community.domain;

import com.feather.common.annotation.Excel;
import com.feather.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 水表日志对象 ZHSQ_SBRZ
 * 
 * @author qhn
 * @date 2021-01-07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZhsqSbrzDay extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 水表日志ID */
    private String sbrzid;
    /** 水表ID */
    @Excel(name = "水表ID")
    private String SBID;
    /** 结算日流量 */
    @Excel(name = "日流量")
    private double dayFlow;
    /** 设备累计流量 */
    @Excel(name = "设备累计流量")
    private Double total;
}
