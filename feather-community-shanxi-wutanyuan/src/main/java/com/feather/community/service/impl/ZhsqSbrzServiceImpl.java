package com.feather.community.service.impl;

import java.text.SimpleDateFormat;
import java.util.*;

import com.feather.common.config.UidWorker;
import com.feather.community.domain.ZhsqSb;
import com.feather.community.mapper.ZhsqSbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.feather.community.mapper.ZhsqSbrzMapper;
import com.feather.community.domain.ZhsqSbrz;
import com.feather.community.service.IZhsqSbrzService;
import com.feather.common.core.text.Convert;

/**
 * 水表日志Service业务层处理
 *
 * @author qhn
 * @date 2021-01-07
 */
@Service
public class ZhsqSbrzServiceImpl implements IZhsqSbrzService {
    @Autowired
    private ZhsqSbrzMapper zhsqSbrzMapper;
    @Autowired
    private ZhsqSbMapper zhsqSbMapper;
    @Autowired
    private UidWorker uidWorker;

    /**
     * 查询水表日志
     *
     * @param sbrzid 水表日志ID
     * @return 水表日志
     */
    @Override
    public ZhsqSbrz selectZhsqSbrzById(String sbrzid) {
        return zhsqSbrzMapper.selectZhsqSbrzById(sbrzid);
    }

    /**
     * 查询水表日志列表
     *
     * @param zhsqSbrz 水表日志
     * @return 水表日志
     */
    @Override
    public List<ZhsqSbrz> selectZhsqSbrzList(ZhsqSbrz zhsqSbrz) {
        return zhsqSbrzMapper.selectZhsqSbrzList(zhsqSbrz);
    }

    /**
     * 新增水表日志
     *
     * @param zhsqSbrz 水表日志
     * @return 结果
     */
    @Override
    public int insertZhsqSbrz(ZhsqSbrz zhsqSbrz) {
        ZhsqSb sb=zhsqSbMapper.selectZhsqSbById(zhsqSbrz.getDeviceCode());
        sb.setSbzt("在线");
        String shrzid = "SBRZ" + uidWorker.getNextId();
        zhsqSbrz.setSbrzid(shrzid);
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        zhsqSbrz.setYear(year);
        zhsqSbrz.setMonth(month);
        zhsqSbrz.setDay(day);
        zhsqSbMapper.updateZhsqSb(sb);
        return zhsqSbrzMapper.insertZhsqSbrz(zhsqSbrz);
    }

    /**
     * 修改水表日志
     *
     * @param zhsqSbrz 水表日志
     * @return 结果
     */
    @Override
    public int updateZhsqSbrz(ZhsqSbrz zhsqSbrz) {
        return zhsqSbrzMapper.updateZhsqSbrz(zhsqSbrz);
    }

    /**
     * 删除水表日志对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteZhsqSbrzByIds(String ids) {
        return zhsqSbrzMapper.deleteZhsqSbrzByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除水表日志信息
     *
     * @param sbrzid 水表日志ID
     * @return 结果
     */
    public int deleteZhsqSbrzById(String sbrzid) {
        return zhsqSbrzMapper.deleteZhsqSbrzById(sbrzid);
    }

    @Override
    public List<Map<String, String>> get5DayData() {
        return zhsqSbrzMapper.get5DayData();
    }

    @Override
    public List<Map<String, Object>> selectZhsqSbrzByIdNew(String deviceCode) {
        return zhsqSbrzMapper.selectZhsqSbrzByIdNew(deviceCode);
    }

    @Override
    public List<Map<String, Object>> selectZhsqSbrzById1List(String deviceCode) {
        return zhsqSbrzMapper.selectZhsqSbrzById1List(deviceCode);
    }
    @Override
    public List<Map<String, Object>> selectZhsqSbrzByIdAndSEList(String deviceCode,String start, String end) {
        return zhsqSbrzMapper.selectZhsqSbrzByIdAndSEList(deviceCode,start,end);
    }
}
