package com.feather.community.service.impl;

import com.feather.common.config.UidWorker;
import com.feather.common.core.text.Convert;
import com.feather.community.domain.ZhsqJg;
import com.feather.community.domain.ZhsqJgDistance;
import com.feather.community.domain.ZhsqSxt;
import com.feather.community.domain.ZhsqYc;
import com.feather.community.mapper.ZhsqJgDistanceMapper;
import com.feather.community.mapper.ZhsqJgMapper;
import com.feather.community.mapper.ZhsqYcMapper;
import com.feather.community.service.IZhsqJgDistanceService;
import com.feather.community.service.IZhsqJgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * 井盖Service业务层处理
 * 
 * @author fancy
 * @date 2020-12-11
 */
@Service
public class ZhsqJgDistanceServiceImpl implements IZhsqJgDistanceService
{
    @Autowired
    private ZhsqJgDistanceMapper zhsqJgDistanceMapper;
    @Autowired
    private ZhsqJgMapper zhsqJgMapper;
    @Autowired
    private ZhsqYcMapper zhsqYcMapper;
    @Autowired
    private UidWorker uidWorker;


    /**
     * 新增井盖距离
     *
     * @param zhsqJgDistance 井盖
     * @return 结果
     */
    @Override
    @Transactional
    public int insertZhsqJgDistance(ZhsqJgDistance zhsqJgDistance)
    {
        String sbid = "JGD" + uidWorker.getNextId();
        zhsqJgDistance.setId(sbid);
        //进行查询比较
        ZhsqJg zhsqJg=zhsqJgMapper.selectZhsqJgBySn(zhsqJgDistance.getSn());
        int threshold=zhsqJg.getDistancethreshold();
        if(zhsqJgDistance.getDistance()>threshold){
            System.out.println("井盖距离超过阈值的范围");
            //进行报警值的插入
            ZhsqYc zhsqYc = new ZhsqYc();
            String ycid = "YC" + uidWorker.getNextId();
            zhsqYc.setYcid(ycid);
            zhsqYc.setYcly("井盖距离报警");
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(new Date());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:MM:ss");
            String sdate = sdf.format(calendar.getTime());
            zhsqYc.setYcsj(sdate);
            //这里先统一放入的是未确认
            zhsqYc.setCzzt("未确认");
            zhsqYc.setCzry("李磊");//处置人员
            zhsqYc.setCzjg("");//处置时间
            zhsqYc.setFj("无");
            zhsqYc.setX(zhsqJg.getX());
            zhsqYc.setY(zhsqJg.getY());
            zhsqYc.setZ(zhsqJg.getZ());
            zhsqYc.setXqid(zhsqJg.getXqid());
            zhsqYc.setSbid(zhsqJg.getJgid());
            zhsqYc.setSqid(zhsqJg.getSqid());
            zhsqYc.setSjlx("设备报警事件");
            zhsqYc.setNoticeRead("0");
            zhsqYc.setYcjb("黄");
            zhsqYc.setYcnr("井盖设备发出提示，请及时处理");
            int d= zhsqYcMapper.insertZhsqYc(zhsqYc);
        }
        zhsqJgDistance.setCreateTime(new Date());
        return zhsqJgDistanceMapper.insertZhsqJgDistance(zhsqJgDistance);
    }


}
