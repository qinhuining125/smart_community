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
import java.util.*;

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

        List<Map<String, Object>> lastzhsqJgDistance=zhsqJgDistanceMapper.selectZhsqJgDistanceNew();
        int threshold=zhsqJg.getDistancethreshold();
        int result=0;
        if(zhsqJgDistance.getDistance()>threshold){
            zhsqJgDistance.setJgstate("on");
            if ((lastzhsqJgDistance.size()==0)||(lastzhsqJgDistance.size()>0 && lastzhsqJgDistance.get(0).get("JGSTATE").equals("off"))){
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
                zhsqYc.setCzzt("未处置");
                zhsqYc.setCzry("");//处置人员
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
                zhsqYc.setYcnr("井盖距离超过阈值，请及时处理");
                int d= zhsqYcMapper.insertZhsqYc(zhsqYc);
                zhsqJgDistance.setCreateTime(new Date());
                result = zhsqJgDistanceMapper.insertZhsqJgDistance(zhsqJgDistance);
            }
        }else {
            zhsqJgDistance.setJgstate("off");
            if (lastzhsqJgDistance.size()==0||(lastzhsqJgDistance.size()>0 && lastzhsqJgDistance.get(0).get("JGSTATE").equals("on"))) {
                zhsqJgDistance.setCreateTime(new Date());
                result = zhsqJgDistanceMapper.insertZhsqJgDistance(zhsqJgDistance);
            }
        }
        return result;
    }


    /**
     * 查询井盖开关记录
     *
     * @param id 井盖开关记录ID
     * @return 井盖开关记录
     */
    @Override
    public ZhsqJgDistance selectZhsqJgDistanceById(String id)
    {
        return zhsqJgDistanceMapper.selectZhsqJgDistanceById(id);
    }

    /**
     * 查询井盖开关记录列表
     *
     * @param zhsqJgDistance 井盖开关记录
     * @return 井盖开关记录
     */
    @Override
    public List<ZhsqJgDistance> selectZhsqJgDistanceList(ZhsqJgDistance zhsqJgDistance)
    {
        return zhsqJgDistanceMapper.selectZhsqJgDistanceList(zhsqJgDistance);
    }


    /**
     * 修改井盖开关记录
     *
     * @param zhsqJgDistance 井盖开关记录
     * @return 结果
     */
    @Override
    public int updateZhsqJgDistance(ZhsqJgDistance zhsqJgDistance)
    {
        return zhsqJgDistanceMapper.updateZhsqJgDistance(zhsqJgDistance);
    }

    /**
     * 删除井盖开关记录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteZhsqJgDistanceByIds(String ids)
    {
        return zhsqJgDistanceMapper.deleteZhsqJgDistanceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除井盖开关记录信息
     *
     * @param id 井盖开关记录ID
     * @return 结果
     */
    public int deleteZhsqJgDistanceById(String id)
    {
        return zhsqJgDistanceMapper.deleteZhsqJgDistanceById(id);
    }
}
