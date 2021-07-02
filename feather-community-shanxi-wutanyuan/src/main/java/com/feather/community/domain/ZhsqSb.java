package com.feather.community.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.feather.common.annotation.Excel;
import com.feather.common.core.domain.BaseEntity;
import org.springframework.data.annotation.Transient;

import java.util.List;
import java.util.Map;

/**
 * 水表对象 zhsq_sb
 *
 * @author qhn
 * @date 2021-01-07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZhsqSb extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 水表ID */
    @Excel(name = "水表ID")
    private String deviceCode;
    /** 设备类型 */
    private String sblx;
    /** 设备名称 */
    @Excel(name = "设备名称")
    private String sbmc;
    /** 品牌名称 */
    @Excel(name = "品牌名称")
    private String ppmc;
    /** 设备型号 */
    private String sbxh;
    /** 设备状态 */
    @Excel(name = "设备状态")
    private String sbzt;
    /** 经度 */
    @Excel(name = "经度")
    private String x;
    /** 纬度 */
    @Excel(name = "纬度")
    private String y;
    /** 高程 */
    @Excel(name = "高程")
    private String z;
    /** 位置 */
    @Excel(name = "位置")
    private String wz;
    /** $column.columnComment */
    private String ldid;
    /** 小区ID */
    private String xqid;
    /** 社区ID */
    private String sqid;

    /**水表地址（硬件）*/
    @Excel(name = "水表地址")
    private byte waterMeterAddress;
    /**水表编码（硬件）*/
    @Excel(name = "水表编码")
    private String waterMeterSn;
    /**设备编码（硬件）*/
    @Excel(name = "设备编码")
    private String deviceSn;
    /**采集周期（硬件）*/
    @Excel(name = "采集周期")
    private int period;

    //当月用水
    @Transient
    private String dyys;
    //当日用水
    @Transient
    private String drys;

    @Transient
    private String zysl;

    private  List<Map<String, Object>> dayFlow;
}