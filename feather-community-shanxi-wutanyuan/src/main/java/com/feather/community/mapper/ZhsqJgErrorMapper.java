package com.feather.community.mapper;

import com.feather.community.domain.ZhsqJgDistance;
import com.feather.community.domain.ZhsqJgError;

/**
 * 井盖错误Mapper接口
 * 
 * @author fancy
 * @date 2020-12-11
 */
public interface ZhsqJgErrorMapper
{


    /**
     * 新增井盖错误日志
     * 
     * @param zhsqJgError 井盖错误日志
     * @return 结果
     */
    public int insertZhsqJgError(ZhsqJgError zhsqJgError);


}
