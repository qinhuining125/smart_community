package com.feather.community.service;

import com.feather.community.domain.ZhsqJg;
import com.feather.community.domain.ZhsqJgDistance;

import java.util.List;

/**
 * 井盖DisranceService接口
 * 
 * @author fancy
 * @date 2020-12-11
 */
public interface IZhsqJgDistanceService
{

    /**
     * 新增井盖距离日志
     * 
     * @param zhsqJgDistance 井盖距离
     * @return 结果
     */
    public int insertZhsqJgDistance(ZhsqJgDistance zhsqJgDistance);



}
