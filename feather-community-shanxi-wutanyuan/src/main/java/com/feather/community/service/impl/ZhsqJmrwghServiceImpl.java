package com.feather.community.service.impl;

import java.util.List;
import java.util.Map;

import com.feather.common.config.UidWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.feather.community.mapper.ZhsqJmrwghMapper;
import com.feather.community.domain.ZhsqJmrwgh;
import com.feather.community.service.IZhsqJmrwghService;
import com.feather.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author fancy
 * @date 2021-06-21
 */
@Service
public class ZhsqJmrwghServiceImpl implements IZhsqJmrwghService 
{
    @Autowired
    private ZhsqJmrwghMapper zhsqJmrwghMapper;
    @Autowired
    private UidWorker uidWorker;
    /**
     * 查询【请填写功能名称】
     * 
     * @param jmrwghid 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZhsqJmrwgh selectZhsqJmrwghById(String jmrwghid)
    {
        return zhsqJmrwghMapper.selectZhsqJmrwghById(jmrwghid);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zhsqJmrwgh 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZhsqJmrwgh> selectZhsqJmrwghList(ZhsqJmrwgh zhsqJmrwgh)
    {
        return zhsqJmrwghMapper.selectZhsqJmrwghList(zhsqJmrwgh);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zhsqJmrwgh 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZhsqJmrwgh(ZhsqJmrwgh zhsqJmrwgh)
    {
        String rwghid = "RWGH" + uidWorker.getNextId();
        zhsqJmrwgh.setJmrwghid(rwghid);
        return zhsqJmrwghMapper.insertZhsqJmrwgh(zhsqJmrwgh);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zhsqJmrwgh 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZhsqJmrwgh(ZhsqJmrwgh zhsqJmrwgh)
    {
        return zhsqJmrwghMapper.updateZhsqJmrwgh(zhsqJmrwgh);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteZhsqJmrwghByIds(String ids)
    {
        return zhsqJmrwghMapper.deleteZhsqJmrwghByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param jmrwghid 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZhsqJmrwghById(String jmrwghid)
    {
        return zhsqJmrwghMapper.deleteZhsqJmrwghById(jmrwghid);
    }

    @Override
    public List<Map<String, Object>> findAllByJmid(String jmid) {
        return zhsqJmrwghMapper.findAllByJmid(jmid);
    }

    @Override
    public List<Map<String, String>> selectZhsqZdType() {
        return zhsqJmrwghMapper.selectZhsqZdType();
    }

    @Override
    public List<Map<String, Object>> findRwghByJmid(Integer page, Integer size, String jmid) {
        return zhsqJmrwghMapper.findRwghByJmid(page,size,jmid);
    }

    @Override
    public int getRwghCount(String jmid) {
        return zhsqJmrwghMapper.getRwghCount(jmid);
    }
}
