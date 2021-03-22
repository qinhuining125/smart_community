package com.feather.community.mapper;

import com.feather.community.domain.ZhsqJg;
import com.feather.community.domain.ZhsqJgDistance;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 井盖距离Mapper接口
 * 
 * @author fancy
 * @date 2020-12-11
 */
public interface ZhsqJgDistanceMapper
{


    /**
     * 新增井盖距离日志
     * 
     * @param zhsqJgDistance 井盖距离日志
     * @return 结果
     */
    public int insertZhsqJgDistance(ZhsqJgDistance zhsqJgDistance);


}
