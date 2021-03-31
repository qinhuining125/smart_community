package com.feather.community.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.feather.common.config.UidWorker;
import com.feather.community.domain.ZhsqDg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.feather.community.mapper.ZhsqSbMapper;
import com.feather.community.domain.ZhsqSb;
import com.feather.community.service.IZhsqSbService;
import com.feather.common.core.text.Convert;

/**
 * 水表Service业务层处理
 *
 * @author qhn
 * @date 2021-01-07
 */
@Service
public class ZhsqSbServiceImpl implements IZhsqSbService
{
    @Autowired
    private UidWorker uidWorker;
    @Autowired
    private ZhsqSbMapper zhsqSbMapper;

    /**
     * 查询水表
     *
     * @param deviceCode 水表ID
     * @return 水表
     */
    @Override
    public ZhsqSb selectZhsqSbById(String deviceCode)
    {
        return zhsqSbMapper.selectZhsqSbById(deviceCode);
    }

    /**
     * 查询水表列表
     *
     * @param zhsqSb 水表
     * @return 水表
     */
    @Override
    public List<ZhsqSb> selectZhsqSbList(ZhsqSb zhsqSb)
    {
        return zhsqSbMapper.selectZhsqSbList(zhsqSb);
    }

    @Override
    public List<Map<String, String>> getSbDetail(String deviceCode) {
        return zhsqSbMapper.getSbDetail(deviceCode);
    }

    /**
     * 新增水表
     *
     * @param zhsqSb 水表
     * @return 结果
     */
    @Override
    public int insertZhsqSb(ZhsqSb zhsqSb)
    {
        String sbid = "SB" + uidWorker.getNextId();
        zhsqSb.setDeviceCode(sbid);
        return zhsqSbMapper.insertZhsqSb(zhsqSb);
    }

    /**
     * 修改水表
     *
     * @param zhsqSb 水表
     * @return 结果
     */
    @Override
    public int updateZhsqSb(ZhsqSb zhsqSb)
    {
        int b= zhsqSbMapper.updateZhsqSb(zhsqSb);
        return b;
    }

    /**
     * 删除水表对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteZhsqSbByIds(String ids)
    {
        return zhsqSbMapper.deleteZhsqSbByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除水表信息
     *
     * @param deviceCode 水表ID
     * @return 结果
     */
    public int deleteZhsqSbById(String deviceCode)
    {
        return zhsqSbMapper.deleteZhsqSbById(deviceCode);
    }

    @Override
    public List<ZhsqSb> getSbList() {
        List<ZhsqSb> sb=zhsqSbMapper.getSbList();
        List<ZhsqSb> sa=new ArrayList<ZhsqSb>();
        for(int i=0;i<sb.size();i++){
            ZhsqSb entity=sb.get(i);
            List<Map<String, String>> liat= zhsqSbMapper.getSbDetail(entity.getDeviceCode());
            Map<String, String> map= liat.get(0);
            entity.setDyys(String.valueOf(map.get("DYYS")));
            entity.setDrys(String.valueOf( map.get("DRYS") ));
            entity.setZysl(String.valueOf(map.get("ZYSL")));
            sa.add(entity);
        }
        return sa;
    }

    @Override
    public List<ZhsqDg> getDgList() {
        return zhsqSbMapper.getDgList();
    }
}