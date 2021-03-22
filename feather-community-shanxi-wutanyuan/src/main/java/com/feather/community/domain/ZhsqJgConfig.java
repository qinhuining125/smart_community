package com.feather.community.domain;

import com.feather.common.annotation.Excel;
import com.feather.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 井盖配置结果推送 ZHSQ_JG
 * 
 * @author fancy
 * @date 2020-12-11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZhsqJgConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;


    /** 井盖编号 */
    @Excel(name = "井盖编号")
    private String sn;
    /** 井盖距离 */
    @Excel(name = "井盖配置结果")
    private byte result;
}
