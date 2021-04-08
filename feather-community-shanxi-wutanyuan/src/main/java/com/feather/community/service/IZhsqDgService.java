package com.feather.community.service;


import com.feather.community.domain.ZhsqDg;

import java.util.List;

/**
 * 车辆道杆Service接口
 * 
 * @author fancy
 * @date 2021-04-06
 */
public interface IZhsqDgService 
{
    /**
     * 查询车辆道杆
     * 
     * @param dgid 车辆道杆ID
     * @return 车辆道杆
     */
    public ZhsqDg selectZhsqDgById(String dgid);

    /**
     * 查询车辆道杆列表
     * 
     * @param zhsqDg 车辆道杆
     * @return 车辆道杆集合
     */
    public List<ZhsqDg> selectZhsqDgList(ZhsqDg zhsqDg);

    /**
     * 新增车辆道杆
     * 
     * @param zhsqDg 车辆道杆
     * @return 结果
     */
    public int insertZhsqDg(ZhsqDg zhsqDg);

    /**
     * 修改车辆道杆
     * 
     * @param zhsqDg 车辆道杆
     * @return 结果
     */
    public int updateZhsqDg(ZhsqDg zhsqDg);

    /**
     * 批量删除车辆道杆
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZhsqDgByIds(String ids);

    /**
     * 删除车辆道杆信息
     * 
     * @param dgid 车辆道杆ID
     * @return 结果
     */
    public int deleteZhsqDgById(String dgid);
}
