package com.feather.community.service.impl;

import java.text.SimpleDateFormat;
import java.util.*;

import com.feather.common.config.UidWorker;
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
        String shrzid = "SHRZ" + uidWorker.getNextId();
        zhsqSbrz.setSbrzid(shrzid);
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
    public List<String[]> get5DayData() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(calendar.DATE, -1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String before1 = sdf.format(calendar.getTime());
        List<ZhsqSbrz> zhsqSbrzs1 = zhsqSbrzMapper.get5DayData(before1);
        calendar.add(calendar.DATE, -1);
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String before2 = sdf.format(calendar.getTime());
        List<ZhsqSbrz> zhsqSbrzs2 = zhsqSbrzMapper.get5DayData(before2);
        calendar.add(calendar.DATE, -1);
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
        String before3 = sdf.format(calendar.getTime());
        List<ZhsqSbrz> zhsqSbrzs3 = zhsqSbrzMapper.get5DayData(before3);
        calendar.add(calendar.DATE, -1);
        SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd");
        String before4 = sdf.format(calendar.getTime());
        List<ZhsqSbrz> zhsqSbrzs4 = zhsqSbrzMapper.get5DayData(before4);
        calendar.add(calendar.DATE, -1);
        SimpleDateFormat sdf35 = new SimpleDateFormat("yyyy-MM-dd");
        String before5 = sdf.format(calendar.getTime());
        List<ZhsqSbrz> zhsqSbrzs5 = zhsqSbrzMapper.get5DayData(before5);
        String[] dates = new String[5];
        String[] counts = new String[5];

        dates[4] = zhsqSbrzs1.get(0).getDeviceClock();
        dates[3] = zhsqSbrzs2.get(0).getDeviceClock();
        dates[2] = zhsqSbrzs3.get(0).getDeviceClock();
        dates[1] = zhsqSbrzs4.get(0).getDeviceClock();
        dates[0] = zhsqSbrzs5.get(0).getDeviceClock();

        Long consumption1 = zhsqSbrzs1.get(0).getDeviceTotalData() - zhsqSbrzs1.get(zhsqSbrzs1.size()-1).getDeviceTotalData();
        counts[4] = consumption1.toString();
        Long consumption2 = zhsqSbrzs2.get(0).getDeviceTotalData() - zhsqSbrzs2.get(zhsqSbrzs2.size()-1).getDeviceTotalData();
        counts[3] = consumption2.toString();
        Long consumption3 = zhsqSbrzs3.get(0).getDeviceTotalData() - zhsqSbrzs3.get(zhsqSbrzs3.size()-1).getDeviceTotalData();
        counts[2] = consumption3.toString();
        Long consumption4 = zhsqSbrzs4.get(0).getDeviceTotalData() - zhsqSbrzs4.get(zhsqSbrzs4.size()-1).getDeviceTotalData();
        counts[1] = consumption4.toString();
        Long consumption5 = zhsqSbrzs5.get(0).getDeviceTotalData() - zhsqSbrzs5.get(zhsqSbrzs5.size()-1).getDeviceTotalData();
        counts[0] = consumption5.toString();
        List<String[]> list = new ArrayList<>();
        list.add(dates);
        list.add(counts);
        return list;
    }
}
