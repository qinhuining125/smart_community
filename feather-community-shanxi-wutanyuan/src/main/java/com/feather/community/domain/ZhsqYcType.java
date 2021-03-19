package com.feather.community.domain;

import com.feather.common.annotation.Excel;
import com.feather.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 异常信息对象 ZHSQ_YC
 * 
 * @author fancy
 * @date 2020-05-14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZhsqYcType extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    /** 告警类型-->目前只有摄像头普通告警需要 */
    private String eventType;
    private String name;
}
