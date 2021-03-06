package com.feather.community.mapper;

import java.util.List;

import com.feather.community.domain.ZhsqCl;

/**
 * 车辆Mapper接口
 * 
 * @author fancy
 * @date 2020-05-15
 */
public interface ZhsqClMapper {
    /**
     * 查询车辆
     * 
     * @param clid
     *            车辆ID
     * @return 车辆
     */
    public ZhsqCl selectZhsqClById(String clid);

    /**
     * 查询车辆列表
     * 
     * @param zhsqCl
     *            车辆
     * @return 车辆集合
     */
    public List<ZhsqCl> selectZhsqClList(ZhsqCl zhsqCl);

    /**
     * 新增车辆
     * 
     * @param zhsqCl
     *            车辆
     * @return 结果
     */
    public int insertZhsqCl(ZhsqCl zhsqCl);

    /**
     * 修改车辆
     * 
     * @param zhsqCl
     *            车辆
     * @return 结果
     */
    public int updateZhsqCl(ZhsqCl zhsqCl);

    /**
     * 删除车辆
     * 
     * @param clid
     *            车辆ID
     * @return 结果
     */
    public int deleteZhsqClById(String clid);

    /**
     * 批量删除车辆
     * 
     * @param clids
     *            需要删除的数据ID
     * @return 结果
     */
    public int deleteZhsqClByIds(String[] clids);
}
