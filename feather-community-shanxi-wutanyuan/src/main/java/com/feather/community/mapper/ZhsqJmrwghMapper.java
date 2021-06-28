package com.feather.community.mapper;

import com.feather.community.domain.ZhsqJmrwgh;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author fancy
 * @date 2021-06-21
 */
public interface ZhsqJmrwghMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param jmrwghid 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZhsqJmrwgh selectZhsqJmrwghById(String jmrwghid);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zhsqJmrwgh 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZhsqJmrwgh> selectZhsqJmrwghList(ZhsqJmrwgh zhsqJmrwgh);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zhsqJmrwgh 【请填写功能名称】
     * @return 结果
     */
    public int insertZhsqJmrwgh(ZhsqJmrwgh zhsqJmrwgh);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zhsqJmrwgh 【请填写功能名称】
     * @return 结果
     */
    public int updateZhsqJmrwgh(ZhsqJmrwgh zhsqJmrwgh);

    /**
     * 删除【请填写功能名称】
     * 
     * @param jmrwghid 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZhsqJmrwghById(String jmrwghid);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param jmrwghids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZhsqJmrwghByIds(String[] jmrwghids);

    List<Map<String, Object>> findAllByJmid(String jmid);

    List<Map<String, String>> selectZhsqZdType();

    List<Map<String, Object>> findRwghByJmid(@Param("page")Integer page, @Param("size")Integer size, @Param("jmid")String jmid);

    int getRwghCount(@Param("page")String jmid);
}
