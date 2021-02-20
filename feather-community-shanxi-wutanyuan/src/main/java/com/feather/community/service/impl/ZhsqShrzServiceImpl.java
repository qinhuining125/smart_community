package com.feather.community.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.feather.common.config.UidWorker;
import com.feather.community.domain.ZhsqSh;
import com.feather.community.domain.ZhsqShrz;
import com.feather.community.domain.ZhsqYc;
import com.feather.community.domain.ZhsqYg;
import com.feather.community.mapper.ZhsqShMapper;
import com.feather.community.mapper.ZhsqShrzMapper;
import com.feather.community.mapper.ZhsqYcMapper;
import com.feather.community.service.IZhsqShrzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feather.common.core.text.Convert;

/**
 * 手环日志Service业务层处理
 *
 * @author fancy
 * @date 2020-12-14
 */
@Service
public class ZhsqShrzServiceImpl implements IZhsqShrzService
{
    @Autowired
    private UidWorker uidWorker;
    @Autowired
    private ZhsqShrzMapper zhsqShrzMapper;
    @Autowired
    private ZhsqShMapper zhsqShMapper;
    @Autowired
    private ZhsqYcMapper zhsqYcMapper;

    /**
     * 查询手环日志
     *
     * @param shrzid 手环日志ID
     * @return 手环日志
     */
    @Override
    public ZhsqShrz selectZhsqShrzById(String shrzid)
    {
        return zhsqShrzMapper.selectZhsqShrzById(shrzid);
    }

    /**
     * 查询手环日志列表
     *
     * @param zhsqShrz 手环日志
     * @return 手环日志
     */
    @Override
    public List<ZhsqShrz> selectZhsqShrzList(ZhsqShrz zhsqShrz)
    {
        return zhsqShrzMapper.selectZhsqShrzList(zhsqShrz);
    }

    /**
     * 新增手环日志
     *
     * @param zhsqShrz 手环日志
     * @return 结果
     */
    @Override
    public int insertZhsqShrz(ZhsqShrz zhsqShrz)
    {
        String shrzid = "SHRZ" + uidWorker.getNextId();
        zhsqShrz.setShrzid(shrzid);

        String alarmState = zhsqShrz.getAlarmState();
        ZhsqYc zhsqYc=new ZhsqYc();
        String ycid = "YC" + uidWorker.getNextId();
        zhsqYc.setYcid(ycid);
        zhsqYc.setYcly("设备报警");
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        String sdate = sdf.format(calendar.getTime());
        zhsqYc.setYcsj(sdate);
        zhsqYc.setCzzt("未处置");
        zhsqYc.setCzry("李磊");//处置人员
        zhsqYc.setCzjg("");//处置时间
        zhsqYc.setFj("无");
        ZhsqSh zhsqSh= zhsqShMapper.selectZhsqShById(zhsqShrz.getShid());
        zhsqYc.setX(zhsqSh.getX());
        zhsqYc.setY(zhsqSh.getY());
        zhsqYc.setZ(zhsqSh.getZ());
        zhsqYc.setXqid(zhsqSh.getXqid());
        zhsqYc.setSbid(zhsqSh.getShid());
        zhsqYc.setSqid(zhsqSh.getSqid());
        zhsqYc.setSjlx("手环报警事件");
        zhsqYc.setNoticeRead("0");
        if (alarmState.equals("01")){
            zhsqYc.setYcjb("红");
            zhsqYc.setYcnr("手环设备发生“SOS”报警，请马上处理");
            zhsqYcMapper.insertZhsqYc(zhsqYc);
        }
        if (alarmState.equals("02")){
            zhsqYc.setYcjb("绿");
            zhsqYc.setYcnr("手环设备发生低电量报警，请前往处理");
            zhsqYcMapper.insertZhsqYc(zhsqYc);
        }
        if (alarmState.equals("03")){
            zhsqYc.setYcjb("黄");
            zhsqYc.setYcnr("手环设备发生脱落报警，请前往处理");
            zhsqYcMapper.insertZhsqYc(zhsqYc);
        }
        if (alarmState.equals("04")){
            zhsqYc.setYcjb("绿");
            zhsqYc.setYcnr("手环设备发生佩戴提醒报警，请前往处理");
            zhsqYcMapper.insertZhsqYc(zhsqYc);
        }
        if (alarmState.equals("05")){
            zhsqYc.setYcjb("绿");
            zhsqYc.setYcnr("手环设备发生剪断报警，请前往处理");
            zhsqYcMapper.insertZhsqYc(zhsqYc);
        }
        if (alarmState.equals("06")){
            zhsqYc.setYcjb("红");
            zhsqYc.setYcnr("手环设备发生跌倒报警，请前往处理");
            zhsqYcMapper.insertZhsqYc(zhsqYc);
        }
        if (alarmState.equals("07")){
            zhsqYc.setYcjb("红");
            zhsqYc.setYcnr("手环设备发生心率异常报警，请前往处理");
            zhsqYcMapper.insertZhsqYc(zhsqYc);
        }
        if (alarmState.equals("08")){
            zhsqYc.setYcjb("黄");
            zhsqYc.setYcnr("手环设备发生心率过高报警，请前往处理");
            zhsqYcMapper.insertZhsqYc(zhsqYc);
        }
        if (alarmState.equals("09")){
            zhsqYc.setYcjb("黄");
            zhsqYc.setYcnr("手环设备发生心率过低报警，请前往处理");
            zhsqYcMapper.insertZhsqYc(zhsqYc);
        }
        if (alarmState.equals("10")){
            zhsqYc.setYcjb("黄");
            zhsqYc.setYcnr("手环设备发生收缩压过高报警，请前往处理");
            zhsqYcMapper.insertZhsqYc(zhsqYc);
        }
        if (alarmState.equals("11")){
            zhsqYc.setYcjb("黄");
            zhsqYc.setYcnr("手环设备发生收缩压过低报警，请前往处理");
            zhsqYcMapper.insertZhsqYc(zhsqYc);
        }
        if (alarmState.equals("12")){
            zhsqYc.setYcjb("黄");
            zhsqYc.setYcnr("手环设备发生舒张压过高报警，请前往处理");
            zhsqYcMapper.insertZhsqYc(zhsqYc);
        }
        if (alarmState.equals("13")){
            zhsqYc.setYcjb("黄");
            zhsqYc.setYcnr("手环设备发生舒张压过低报警，请前往处理");
            zhsqYcMapper.insertZhsqYc(zhsqYc);
        }
        return zhsqShrzMapper.insertZhsqShrz(zhsqShrz);
    }

    /**
     * 修改手环日志
     *
     * @param zhsqShrz 手环日志
     * @return 结果
     */
    @Override
    public int updateZhsqShrz(ZhsqShrz zhsqShrz)
    {
        return zhsqShrzMapper.updateZhsqShrz(zhsqShrz);
    }

    /**
     * 删除手环日志对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteZhsqShrzByIds(String ids)
    {
        return zhsqShrzMapper.deleteZhsqShrzByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除手环日志信息
     *
     * @param shrzid 手环日志ID
     * @return 结果
     */
    @Override
    public int deleteZhsqShrzById(String shrzid)
    {
        return zhsqShrzMapper.deleteZhsqShrzById(shrzid);
    }
}