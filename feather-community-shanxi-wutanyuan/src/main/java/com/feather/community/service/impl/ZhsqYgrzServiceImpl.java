package com.feather.community.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.feather.common.config.UidWorker;
import com.feather.community.domain.ZhsqYc;
import com.feather.community.domain.ZhsqYg;
import com.feather.community.mapper.ZhsqYcMapper;
import com.feather.community.mapper.ZhsqYgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.feather.community.mapper.ZhsqYgrzMapper;
import com.feather.community.domain.ZhsqYgrz;
import com.feather.community.service.IZhsqYgrzService;
import com.feather.common.core.text.Convert;

/**
 * 烟感日志Service业务层处理
 * 
 * @author qhn
 * @date 2021-01-08
 */
@Service
public class ZhsqYgrzServiceImpl implements IZhsqYgrzService 
{
    @Autowired
    private ZhsqYgrzMapper zhsqYgrzMapper;
    @Autowired
    private UidWorker uidWorker;
    @Autowired
    private ZhsqYcMapper zhsqYcMapper;
    @Autowired
    private ZhsqYgMapper zhsqYgMapper;

    /**
     * 查询烟感日志
     * 
     * @param sbrzid 烟感日志ID
     * @return 烟感日志
     */
    @Override
    public ZhsqYgrz selectZhsqYgrzById(String sbrzid)
    {
        return zhsqYgrzMapper.selectZhsqYgrzById(sbrzid);
    }

    /**
     * 查询烟感日志列表
     * 
     * @param zhsqYgrz 烟感日志
     * @return 烟感日志
     */
    @Override
    public List<ZhsqYgrz> selectZhsqYgrzList(ZhsqYgrz zhsqYgrz)
    {
        return zhsqYgrzMapper.selectZhsqYgrzList(zhsqYgrz);
    }

    /**
     * 新增烟感日志
     * 
     * @param zhsqYgrz 烟感日志
     * @return 结果
     */
    @Override
    public int insertZhsqYgrz(ZhsqYgrz zhsqYgrz)
    {
        String ygrzid = "YGRZ" + uidWorker.getNextId();
        zhsqYgrz.setSbrzid(ygrzid);

        long content = zhsqYgrz.getContent();
        ZhsqYc zhsqYc=new ZhsqYc();
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
        ZhsqYg zhsqYg= zhsqYgMapper.selectZhsqYgByIMSI(zhsqYgrz.getImsi());
        zhsqYc.setX(zhsqYg.getX());
        zhsqYc.setY(zhsqYg.getY());
        zhsqYc.setZ(zhsqYg.getZ());
        zhsqYc.setXqid(zhsqYg.getXqid());
        zhsqYc.setSbid(zhsqYg.getYgid());
        zhsqYc.setSqid(zhsqYg.getSqid());
        zhsqYc.setSjlx("设备报警事件");
        zhsqYc.setNoticeRead("0");
        if (content==1){
            zhsqYc.setYcjb("红");
            zhsqYc.setYcnr("烟感设备发生烟感报警，请马上处理");
            zhsqYcMapper.insertZhsqYc(zhsqYc);
        }
        if (content==2){
            zhsqYc.setYcjb("黄");
            zhsqYc.setYcnr("烟感设备发生烟感防拆报警，请马上处理");
            zhsqYcMapper.insertZhsqYc(zhsqYc);
        }
        if (content==3){
            zhsqYc.setYcjb("绿");
            zhsqYc.setYcnr("烟感设备发生低电量报警，请前往处理");
            zhsqYcMapper.insertZhsqYc(zhsqYc);
        }
        return zhsqYgrzMapper.insertZhsqYgrz(zhsqYgrz);
    }

    /**
     * 修改烟感日志
     * 
     * @param zhsqYgrz 烟感日志
     * @return 结果
     */
    @Override
    public int updateZhsqYgrz(ZhsqYgrz zhsqYgrz)
    {
        return zhsqYgrzMapper.updateZhsqYgrz(zhsqYgrz);
    }

    /**
     * 删除烟感日志对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteZhsqYgrzByIds(String ids)
    {
        return zhsqYgrzMapper.deleteZhsqYgrzByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除烟感日志信息
     * 
     * @param sbrzid 烟感日志ID
     * @return 结果
     */
    public int deleteZhsqYgrzById(String sbrzid)
    {
        return zhsqYgrzMapper.deleteZhsqYgrzById(sbrzid);
    }

}
