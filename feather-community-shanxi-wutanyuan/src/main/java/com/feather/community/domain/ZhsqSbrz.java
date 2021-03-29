package com.feather.community.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.feather.common.annotation.Excel;
import com.feather.common.core.domain.BaseEntity;

/**
 * 水表日志对象 ZHSQ_SBRZ
 * 
 * @author qhn
 * @date 2021-01-07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZhsqSbrz extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 水表日志ID */
    private String sbrzid;
    /** 水表ID */
    @Excel(name = "水表ID")
    private String deviceCode;
    /** 结算日流量 */
    @Excel(name = "设备瞬时流量")
    private double instant;
    /** 设备累计流量 */
    @Excel(name = "设备累计流量")
    private Double total;
    /** 设备状态 */
    @Excel(name = "水表编码")
    private String waterMeterSn;
    @Excel(name = "设备编码")
    private String deviceSn;
//    @Excel(name = "开始时间")
//    private String beginCreateTime;
//    @Excel(name = "结束时间")
//    private String endCreateTime;
}
