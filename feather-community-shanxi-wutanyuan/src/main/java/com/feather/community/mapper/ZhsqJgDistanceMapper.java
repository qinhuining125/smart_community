package com.feather.community.mapper;

import com.feather.community.domain.ZhsqJg;
import com.feather.community.domain.ZhsqJgDistance;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 井盖距离Mapper接口
 * 
 * @author fancy
 * @date 2020-12-11
 */
public interface ZhsqJgDistanceMapper
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
     * 删除井盖开关记录
     *
     * @param id 井盖开关记录ID
     * @return 结果
     */
    public int deleteZhsqJgDistanceById(String id);

    /**
     * 批量删除井盖开关记录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZhsqJgDistanceByIds(String[] ids);

    List<Map<String, Object>> selectZhsqJgDistanceNew();

    List<Map<String, Object>> findBySn(String sn);

    ;
}
