package com.feather.community.domain;

import com.feather.common.annotation.Excel;
import com.feather.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 车辆进出对象 ZHSQ_CLJC
 * 
 * @author fancy
 * @date 2020-05-15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZhsqClJc extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 车辆id */
    private String clid;
    /** 车牌号码 */
    @Excel(name = "车牌号码")
    private String clhm;
    /** 车型(大型,小型) */
    @Excel(name = "车型(大型,小型)")
    private String cx;
    /** 车主姓名 */
    @Excel(name = "车主姓名")
    private String czxm;
    /** 车主联系电话 */
    @Excel(name = "车主联系电话")
    private String lxdh;
    /** 车主id */
    @Excel(name = "车主id")
    private String jmid;

    /**车辆类型，外来车辆和小区车辆*/
    private String cllx;
    /**进出状态*/
    private String jczt;
}
