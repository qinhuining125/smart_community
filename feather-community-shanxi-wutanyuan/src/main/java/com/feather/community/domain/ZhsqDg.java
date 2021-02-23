package com.feather.community.domain;

import com.feather.common.annotation.Excel;
import com.feather.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-07 11:23
 * @description 智慧社区_党员 ZHSQ_DY
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZhsqDg extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 道杆ID */
    @Excel(name = "道杆ID")
    private String dgid;
    /** 社区ID */
    @Excel(name = "社区ID")
    private String sqid;
    /** 小区ID */
    @Excel(name = "小区ID")
    private String xqid;
    /** 位置 */
    @Excel(name = "位置")
    private String wz;
    /** 设备状态 */
    @Excel(name = "设备状态")
    private String sbzt;
    /** 设备型号 */
    @Excel(name = "设备型号")
    private String sbxh;
    /** 品牌名称 */
    @Excel(name = "品牌名称")
    private String ppmc;
    /** 设备名称 */
    @Excel(name = "设备名称")
    private String sbmc;
    /** 设备类型 */
    @Excel(name = "设备类型")
    private String sblx;
    /** 经度 */
    @Excel(name = "经度")
    private String x;
    /** 高程 */
    @Excel(name = "高程")
    private String z;
    /** 纬度 */
    @Excel(name = "纬度")
    private String y;
}
