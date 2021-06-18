package com.feather.community.service;

import com.feather.community.domain.ZhsqSbrz;
import java.util.List;
import java.util.Map;

/**
 * 水表日志Service接口
 * 
 * @author qhn
 * @date 2021-01-07
 */
public interface IZhsqSbrzService 
{
    /**
     * 查询水表日志
     * 
     * @param sbrzid 水表日志ID
     * @return 水表日志
     */
    public ZhsqSbrz selectZhsqSbrzById(String sbrzid);

    /**
     * 查询水表日志列表
     * 
     * @param zhsqSbrz 水表日志
     * @return 水表日志集合
     */
    public List<ZhsqSbrz> selectZhsqSbrzList(ZhsqSbrz zhsqSbrz);

    /**
     * 新增水表日志
     * 
     * @param zhsqSbrz 水表日志
     * @return 结果
     */
    public int insertZhsqSbrz(ZhsqSbrz zhsqSbrz);

    /**
     * 修改水表日志
     * 
     * @param zhsqSbrz 水表日志
     * @return 结果
     */
    public int updateZhsqSbrz(ZhsqSbrz zhsqSbrz);

    /**
     * 批量删除水表日志
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZhsqSbrzByIds(String ids);

    /**
     * 删除水表日志信息
     * 
     * @param sbrzid 水表日志ID
     * @return 结果
     */
    public int deleteZhsqSbrzById(String sbrzid);
    /**
     * 获取过去一周内用水情况
     *
     * @return 结果
     */
    List<Map<String, String>> get5DayData();
    /**
     * 获取最新
     *
     * @return 结果
     */
    List<Map<String, Object>> selectZhsqSbrzByIdNew(String deviceCode);
    /**
     * 获取水表每天总流量
     *
     * @return 结果
     */
    List<Map<String, Object>> selectZhsqSbrzById1List(String deviceCode);
}
