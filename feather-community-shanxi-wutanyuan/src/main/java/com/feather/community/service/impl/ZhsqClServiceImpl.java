package com.feather.community.service.impl;

import java.util.List;

import com.feather.common.config.UidWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feather.common.core.text.Convert;
import com.feather.community.domain.ZhsqCl;
import com.feather.community.mapper.ZhsqClMapper;
import com.feather.community.service.IZhsqClService;

/**
 * 车辆Service业务层处理
 * 
 * @author fancy
 * @date 2020-05-15
 */
@Service
public class ZhsqClServiceImpl implements IZhsqClService {
    @Autowired
    private ZhsqClMapper zhsqClMapper;
    @Autowired
    private UidWorker uidWorker;
    /**
     * 查询车辆
     * 
     * @param clid
     *            车辆ID
     * @return 车辆
     */
    @Override
    public ZhsqCl selectZhsqClById(String clid) {
        return zhsqClMapper.selectZhsqClById(clid);
    }

    /**
     * 查询车辆列表
     * 
     * @param zhsqCl
     *            车辆
     * @return 车辆
     */
    @Override
    public List<ZhsqCl> selectZhsqClList(ZhsqCl zhsqCl) {
        return zhsqClMapper.selectZhsqClList(zhsqCl);
    }

    /**
     * 新增车辆
     * 
     * @param zhsqCl
     *            车辆
     * @return 结果
     */
    @Override
    public int insertZhsqCl(ZhsqCl zhsqCl) {
        String ygid = "CL" + uidWorker.getNextId();
        zhsqCl.setClid(ygid);
        return zhsqClMapper.insertZhsqCl(zhsqCl);
    }

    /**
     * 修改车辆
     * 
     * @param zhsqCl
     *            车辆
     * @return 结果
     */
    @Override
    public int updateZhsqCl(ZhsqCl zhsqCl) {
        return zhsqClMapper.updateZhsqCl(zhsqCl);
    }

    /**
     * 删除车辆对象
     * 
     * @param ids
     *            需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteZhsqClByIds(String ids) {
        return zhsqClMapper.deleteZhsqClByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除车辆信息
     * 
     * @param clid
     *            车辆ID
     * @return 结果
     */
    public int deleteZhsqClById(String clid) {
        return zhsqClMapper.deleteZhsqClById(clid);
    }
}
