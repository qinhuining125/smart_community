package com.feather.community.service.impl;

import java.util.List;

import com.feather.common.config.UidWorker;
import com.feather.community.domain.ZhsqDg;
import com.feather.community.mapper.ZhsqDgMapper;
import com.feather.community.service.IZhsqDgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.feather.common.core.text.Convert;

/**
 * 车辆道杆Service业务层处理
 * 
 * @author fancy
 * @date 2021-04-06
 */
@Service
public class ZhsqDgServiceImpl implements IZhsqDgService
{
    @Autowired
    private ZhsqDgMapper zhsqDgMapper;
    @Autowired
    private UidWorker uidWorker;
    /**
     * 查询车辆道杆
     * 
     * @param dgid 车辆道杆ID
     * @return 车辆道杆
     */
    @Override
    public ZhsqDg selectZhsqDgById(String dgid)
    {
        return zhsqDgMapper.selectZhsqDgById(dgid);
    }

    /**
     * 查询车辆道杆列表
     * 
     * @param zhsqDg 车辆道杆
     * @return 车辆道杆
     */
    @Override
    public List<ZhsqDg> selectZhsqDgList(ZhsqDg zhsqDg)
    {
        return zhsqDgMapper.selectZhsqDgList(zhsqDg);
    }

    /**
     * 新增车辆道杆
     * 
     * @param zhsqDg 车辆道杆
     * @return 结果
     */
    @Override
    public int insertZhsqDg(ZhsqDg zhsqDg)
    {
        String dgid = "DG" + uidWorker.getNextId();
        zhsqDg.setDgid(dgid);
        return zhsqDgMapper.insertZhsqDg(zhsqDg);
    }

    /**
     * 修改车辆道杆
     * 
     * @param zhsqDg 车辆道杆
     * @return 结果
     */
    @Override
    public int updateZhsqDg(ZhsqDg zhsqDg)
    {
        return zhsqDgMapper.updateZhsqDg(zhsqDg);
    }

    /**
     * 删除车辆道杆对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteZhsqDgByIds(String ids)
    {
        return zhsqDgMapper.deleteZhsqDgByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除车辆道杆信息
     * 
     * @param dgid 车辆道杆ID
     * @return 结果
     */
    public int deleteZhsqDgById(String dgid)
    {
        return zhsqDgMapper.deleteZhsqDgById(dgid);
    }
}
