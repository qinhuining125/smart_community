package com.feather.community.mapper;

import com.feather.community.domain.ZhsqJgDistance;
import com.feather.community.domain.ZhsqJgrz;

import java.util.List;
import java.util.Map;

/**
 * 井盖距离Mapper接口
 * 
 * @author fancy
 * @date 2020-12-11
 */
public interface ZhsqJgrzMapper
{


    /**
     * 查询井盖开关记录
     *
     * @param id 井盖开关记录ID
     * @return 井盖开关记录
     */
    public ZhsqJgrz selectZhsqJgrzById(String id);

    /**
     * 查询井盖开关记录列表
     *
     * @param zhsqJgrz 井盖日志记录
     * @return 井盖开关记录集合
     */
    public List<ZhsqJgrz> selectZhsqJgrzList(ZhsqJgrz zhsqJgrz);

    /**
     * 新增井盖开关记录
     *
     * @param zhsqJgrz 井盖开关记录
     * @return 结果
     */
    public int insertZhsqJgrz(ZhsqJgrz zhsqJgrz);

    /**
     * 修改井盖开关记录
     *
     * @param zhsqJgrz 井盖开关记录
     * @return 结果
     */
    public int updateZhsqJgrz(ZhsqJgrz zhsqJgrz);

    /**
     * 删除井盖开关记录
     *
     * @param id 井盖开关记录ID
     * @return 结果
     */
    public int deleteZhsqJgrzById(String id);

    /**
     * 批量删除井盖开关记录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZhsqJgrzByIds(String[] ids);

    List<Map<String, Object>> selectZhsqJgrzNew(String sn);

    List<Map<String, Object>> findBySn(String sn);

    List<Map<String, Object>> findJgDisBySSE(String sn, String start, String end);

    ;
}
