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
     * 查询井盖开关记录
     *
     * @param id 井盖开关记录ID
     * @return 井盖开关记录
     */
    public ZhsqJgDistance selectZhsqJgDistanceById(String id);

    /**
     * 查询井盖开关记录列表
     *
     * @param zhsqJgDistance 井盖开关记录
     * @return 井盖开关记录集合
     */
    public List<ZhsqJgDistance> selectZhsqJgDistanceList(ZhsqJgDistance zhsqJgDistance);

    /**
     * 新增井盖开关记录
     *
     * @param zhsqJgDistance 井盖开关记录
     * @return 结果
     */
    public int insertZhsqJgDistance(ZhsqJgDistance zhsqJgDistance);

    /**
     * 修改井盖开关记录
     *
     * @param zhsqJgDistance 井盖开关记录
     * @return 结果
     */
    public int updateZhsqJgDistance(ZhsqJgDistance zhsqJgDistance);

    /**
     * 批量删除井盖开关记录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZhsqJgDistanceByIds(String ids);

    /**
     * 删除井盖开关记录信息
     *
     * @param id 井盖开关记录ID
     * @return 结果
     */
    public int deleteZhsqJgDistanceById(String id);
}
