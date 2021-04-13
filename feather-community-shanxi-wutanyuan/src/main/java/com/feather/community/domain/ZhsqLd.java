package com.feather.community.domain;

import com.feather.common.annotation.Excel;
import com.feather.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-07 11:23
 * @description 智慧社区_楼栋 ZHSQ_LD
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZhsqLd extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 楼栋id */
    @Excel(name = "楼栋ID")
    private String ldid;

    /** 楼栋名称 */
    @Excel(name = "楼栋名称")
    private String ldmc;

    /** 建筑物面积 */
    @Excel(name = "楼栋面积")
    private String jzwmj;

    /** 层数 */
    @Excel(name = "楼栋层数")
    private String cs;

    /** 小区id */
    private String xqid;

    /** 社区id */
    private String sqid;

    /** 所属街道 */
    @Excel(name = "所属街道")
    private String ssjd;

    @Excel(name = "经度")
    private String x;
    @Excel(name = "纬度")
    private String y;
    @Excel(name = "高程")
    private String z;

    private List<ZhsqFw> zhsqFwList;

    private List<ZhsqLdVo> zhsqFwListMap;

    private List<ZhsqYgVo> zhsqYgListMap;

}
