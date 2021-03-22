package com.feather.community.domain;

import com.feather.common.annotation.Excel;
import com.feather.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 井盖对象 ZHSQ_JG_ERROR
 * 
 * @author fancy
 * @date 2020-12-11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZhsqJgError extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 井盖测距日志ID */
    @Excel(name = "井盖错误日志ID")
    private String id;
    /** 井盖编号 */
    @Excel(name = "井盖编号")
    private String sn;
    /** 井盖距离 */
    @Excel(name = "井盖错误编码")
    private byte error;
}
