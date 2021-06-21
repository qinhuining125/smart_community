package com.feather.community.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.feather.common.annotation.Excel;
import com.feather.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 ZHSQ_JMRWGH
 * 
 * @author fancy
 * @date 2021-06-21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZhsqJmrwgh extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 人文关怀id */
    @Excel(name = "人文关怀id")
    private String jmrwghid;
    /** 居民id */
    @Excel(name = "居民id")
    private String jmid;
    /** 人员 */
    @Excel(name = "人员")
    private String personnel;
    /** 事件 */
    @Excel(name = "事件")
    private String event;
    /** 时间 */
    @Excel(name = "时间")
    private String time;
}
