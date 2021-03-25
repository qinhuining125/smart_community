package com.feather.community.service.impl;

import java.text.SimpleDateFormat;
import java.util.*;

import com.feather.common.config.UidWorker;
import com.feather.community.domain.*;
import com.feather.community.mapper.ZhsqSxtMapper;
import com.feather.community.mapper.ZhsqSxtrlbkgjMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feather.common.core.text.Convert;
import com.feather.community.mapper.ZhsqYcMapper;
import com.feather.community.service.IZhsqYcService;

/**
 * 异常信息Service业务层处理
 *
 * @author fancy
 * @date 2020-05-14
 */
@Service
public class ZhsqYcServiceImpl implements IZhsqYcService {
    @Autowired
    private ZhsqYcMapper zhsqYcMapper;
    @Autowired
    private UidWorker uidWorker;
    @Autowired
    private ZhsqSxtMapper zhsqSxtMapper;
    @Autowired
    private ZhsqSxtrlbkgjMapper zhsqSxtrlbkgjMapper;

    /**
     * 查询异常信息
     *
     * @param ycid 异常信息ID
     * @return 异常信息
     */
    @Override
    public ZhsqYc selectZhsqYcById(String ycid) {
        return zhsqYcMapper.selectZhsqYcById(ycid);
    }

    /**
     * 查询异常信息列表
     *
     * @param zhsqYc 异常信息
     * @return 异常信息
     */
    @Override
    public List<ZhsqYc> selectZhsqYcList(ZhsqYc zhsqYc) {
        return zhsqYcMapper.selectZhsqYcList(zhsqYc);
    }

    /**
     * 新增异常信息
     *
     * @param zhsqYc 异常信息
     * @return 结果
     */
    @Override
    public int insertZhsqYc(ZhsqYc zhsqYc) {
        //新添加的默认这个状态值为0
        zhsqYc.setNoticeRead("0");
        return zhsqYcMapper.insertZhsqYc(zhsqYc);
    }

    /**
     * 修改异常信息
     *
     * @param zhsqYc 异常信息
     * @return 结果
     */
    @Override
    public int updateZhsqYc(ZhsqYc zhsqYc) {
        return zhsqYcMapper.updateZhsqYc(zhsqYc);
    }

    /**
     * 删除异常信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteZhsqYcByIds(String ids) {
        return zhsqYcMapper.deleteZhsqYcByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除异常信息信息
     *
     * @param ycid 异常信息ID
     * @return 结果
     */
    public int deleteZhsqYcById(String ycid) {
        return zhsqYcMapper.deleteZhsqYcById(ycid);
    }

    @Override
    public List<Map> getSourceCount(String sqid, String xqid) {
        return zhsqYcMapper.getSourceCount(sqid, xqid);
    }

    @Override
    public List<Map> getStatusCount(String sqid, String xqid) {
        return zhsqYcMapper.getStatusCount(sqid, xqid);
    }

    @Override
    public int insertZhsqSxtpugj(ZhsqSxtptgj zhsqSxtptgj) {
        String sxtpugjid = "SXTPTGJ" + uidWorker.getNextId();
        zhsqSxtptgj.setSxtptgjid(sxtpugjid);

//        long content = zhsqYgrz.getContent();
        ZhsqYc zhsqYc = new ZhsqYc();
        String ycid = "YC" + uidWorker.getNextId();
        zhsqYc.setYcid(ycid);
        zhsqYc.setYcly("摄像头普通报警");
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        String sdate = sdf.format(calendar.getTime());
        zhsqYc.setYcsj(zhsqSxtptgj.getEventTime());
        if (zhsqSxtptgj.getAlarmStatus() == 0) {
            zhsqYc.setCzzt("未处置");
        } else if (zhsqSxtptgj.getAlarmStatus() == 1) {
            zhsqYc.setCzzt("处置中");
        } else if (zhsqSxtptgj.getAlarmStatus() == 2) {
            zhsqYc.setCzzt("处置中");
        } else if (zhsqSxtptgj.getAlarmStatus() == 3) {
            zhsqYc.setCzzt("已处置");
        }
        zhsqYc.setCzry("李磊");//处置人员
        zhsqYc.setCzjg("");//处置时间
        zhsqYc.setFj("无");
        ZhsqSxt zhsqSxt = zhsqSxtMapper.selectZhsqSxtById(zhsqSxtptgj.getDeviceCode());
        zhsqYc.setX(zhsqSxt.getX());
        zhsqYc.setY(zhsqSxt.getY());
        zhsqYc.setZ(zhsqSxt.getZ());
        zhsqYc.setXqid(zhsqSxt.getXqid());
        zhsqYc.setSbid(zhsqSxt.getSxtid());
        zhsqYc.setSqid(zhsqSxt.getSqid());
        zhsqYc.setSjlx("设备报警事件");
        zhsqYc.setNoticeRead("0");
        if (zhsqSxtptgj.getEventSecurity() == 0) {
            zhsqYc.setYcjb("红");
            zhsqYc.setYcnr("摄像头发生危机报警，请马上处理");
        }
        if (zhsqSxtptgj.getEventSecurity() == 1) {
            zhsqYc.setYcjb("黄");
            zhsqYc.setYcnr("摄像头发生报警（主要），请马上处理");
        }
        if (zhsqSxtptgj.getEventSecurity() == 2) {
            zhsqYc.setYcjb("黄");
            zhsqYc.setYcnr("摄像头发生报警（次要），请及时处理");
        }
        if (zhsqSxtptgj.getEventSecurity() == 3) {
            zhsqYc.setYcjb("黄");
            zhsqYc.setYcnr("摄像头发生警告，请及时处理处理");
        }
        if (zhsqSxtptgj.getEventSecurity() == 4) {
            zhsqYc.setYcjb("绿");
            zhsqYc.setYcnr("摄像头发出提示，请及时处理处理");
        }
        zhsqYc.setEventType(zhsqSxtptgj.getEventType());
        return zhsqYcMapper.insertZhsqYc(zhsqYc);
    }

    @Override
    public int insertZhsqSxtrlbkgj(ZhsqSxtrlbkgj zhsqSxtrlbkgj) {
//        String sxtpugjid = "SXTPTGJ" + uidWorker.getNextId();
//        zhsqSxtrlbkgj.setSxtptgjid(sxtpugjid);
//        long content = zhsqYgrz.getContent();
        ZhsqYc zhsqYc = new ZhsqYc();
        String ycid = "YC" + uidWorker.getNextId();
        zhsqYc.setYcid(ycid);
        zhsqYc.setYcly("摄像头人脸布控报警");
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        String sdate = sdf.format(calendar.getTime());
        zhsqYc.setYcsj(zhsqSxtrlbkgj.getAlarmTime());
        zhsqYc.setCzzt("未确认");
        zhsqYc.setCzry("李磊");//处置人员
        zhsqYc.setCzjg("");//处置时间
        zhsqYc.setFj("无");
        ZhsqSxt zhsqSxt = zhsqSxtMapper.selectZhsqSxtById(zhsqSxtrlbkgj.getFacecamCode());
        zhsqYc.setX(zhsqSxt.getX());
        zhsqYc.setY(zhsqSxt.getY());
        zhsqYc.setZ(zhsqSxt.getZ());
        zhsqYc.setXqid(zhsqSxt.getXqid());
        zhsqYc.setSbid(zhsqSxt.getSxtid());
        zhsqYc.setSqid(zhsqSxt.getSqid());
        zhsqYc.setSjlx("设备报警事件");
        zhsqYc.setNoticeRead("0");
        if (zhsqSxtrlbkgj.getAlarmType() == "1" ||zhsqSxtrlbkgj.getAlarmType().equals("1")) {
            zhsqYc.setYcjb("红");
            zhsqYc.setYcnr("摄像头人脸布控黑名单告警");
        }
        if (zhsqSxtrlbkgj.getAlarmType() == "2"||zhsqSxtrlbkgj.getAlarmType().equals("2")) {
            zhsqYc.setYcjb("黄");
            zhsqYc.setYcnr("白名单告警");
        }
        if (zhsqSxtrlbkgj.getAlarmType() == "3"||zhsqSxtrlbkgj.getAlarmType().equals("3")) {
            zhsqYc.setYcjb("黄");
            zhsqYc.setYcnr("为白名单命中告警");
        }
        zhsqYc.setGjsjid(zhsqSxtrlbkgj.getId());
        zhsqSxtrlbkgjMapper.insertZhsqSxtrlbkgj(zhsqSxtrlbkgj);
        return zhsqYcMapper.insertZhsqYc(zhsqYc);
    }
    /**
     * 查询异常信息
     *
     * @param eventType 类型编号
     * @return 异常信息
     */
    @Override
    public ZhsqYcType selectZhsqYcTypeById(String eventType) {
        return zhsqYcMapper.selectZhsqYcTypeById(eventType);
    }

}
