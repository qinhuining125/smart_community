package com.feather.community.service;

import com.feather.community.domain.ZhsqJgDistance;
import com.feather.community.domain.ZhsqJgError;

/**
 * 井盖ErrorService接口
 * 
 * @author fancy
 * @date 2020-12-11
 */
public interface IZhsqJgErrorService
{

    /**
     * 新增井盖错误日志
     * 
     * @param zhsqJgError 井盖错误
     * @return 结果
     */
    public int insertZhsqJgError(ZhsqJgError zhsqJgError);



}
