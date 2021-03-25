package com.feather.community.service.impl;

import com.feather.common.core.domain.AjaxResult;
import com.feather.common.utils.ExceptionUtil;
import com.feather.community.config.CommunityConstants;
import com.feather.community.domain.*;
import com.feather.community.service.*;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-14 17:34
 * @description 设备service
 */
@Service
public class DeviceServiceImpl implements IDeviceService {

    @Autowired
    IZhsqShService zhsqShService;
    @Autowired
    IZhsqShrzService zhsqShrzService;
    @Autowired
    IZhsqSbService zhsqSbService;
    @Autowired
    IZhsqSbrzService zhsqSbrzService;
    @Autowired
    IZhsqYgService zhsqYgService;
    @Autowired
    IZhsqYgrzService zhsqYgrzService;
    @Autowired
    IZhsqSxtService zhsqSxtService;
    @Autowired
    IZhsqYcService zhsqYcService;

    @Override
    public AjaxResult addSh(ZhsqSh zhsqSh) {
        try {
            zhsqShService.insertZhsqSh(zhsqSh);
            return AjaxResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            String errInfo = ExceptionUtil.getExceptionMessage(e);
            return AjaxResult.error(errInfo);
        }
    }

    @Override
    public AjaxResult addShrz(ZhsqShrz zhsqShrz) {
        try {
            String imei = zhsqShrz.getImei();
            if (Strings.isBlank(imei)) {
                return AjaxResult.error(CommunityConstants.NO_IEMI);
            }
            ZhsqSh zhsqSh = zhsqShService.selectZhsqShByImei(imei);
            if (Objects.isNull(zhsqSh)) {
                return AjaxResult.error(CommunityConstants.NO_DEVICE_FOUND);
            }
            zhsqShrz.setShid(zhsqSh.getShid());
            int affectNum = zhsqShrzService.insertZhsqShrz(zhsqShrz);
            if (affectNum > 0) {
                return AjaxResult.success();
            }
            return AjaxResult.error(CommunityConstants.AFFECT_ZERO);
        } catch (Exception e) {
            e.printStackTrace();
            String errInfo = ExceptionUtil.getExceptionMessage(e);
            return AjaxResult.error(errInfo);
        }
    }

    @Override
    public AjaxResult addSbrz(ZhsqSbrz zhsqSbrz) {
        try {

            ZhsqSb zhsqSb =new ZhsqSb();
            zhsqSb.setWaterMeterSn(zhsqSbrz.getWaterMeterSn());
            zhsqSb.setDeviceSn(zhsqSbrz.getDeviceSn());
            List<ZhsqSb> list=zhsqSbService.selectZhsqSbList(zhsqSb);
            if(list==null){
                //没有找到相关的设备信息
                return AjaxResult.error(CommunityConstants.NO_WATER_SN);
            }else{
                //理论上来讲，这里只会出现单一结果
                String deviceCode=zhsqSbService.selectZhsqSbList(zhsqSb).get(0).getDeviceCode();
                zhsqSbrz.setDeviceCode(deviceCode);
                int affectNum = zhsqSbrzService.insertZhsqSbrz(zhsqSbrz);
                if (affectNum > 0) {
                    return AjaxResult.success();
                }
                return AjaxResult.error(CommunityConstants.AFFECT_ZERO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            String errInfo = ExceptionUtil.getExceptionMessage(e);
            return AjaxResult.error(errInfo);
        }
    }

    @Override
    public AjaxResult addYgrz(ZhsqYgrz zhsqYgrz) {
        try {
            String imei = zhsqYgrz.getImei();
            if (Strings.isBlank(imei)) {
                return AjaxResult.error(CommunityConstants.NO_YGID_CODE);
            }
            ZhsqYg zhsqYg = zhsqYgService.selectZhsqYgByImei(imei);
            if (Objects.isNull(zhsqYg)) {
                return AjaxResult.error(CommunityConstants.NO_YGID_CODE);
            }
            zhsqYgrz.setImei(zhsqYg.getImei());
//            zhsqSbrz.setShid(zhsqSh.getShid());
            int affectNum = zhsqYgrzService.insertZhsqYgrz(zhsqYgrz);
            if (affectNum > 0) {
                return AjaxResult.success();
            }
            return AjaxResult.error(CommunityConstants.AFFECT_ZERO);
        } catch (Exception e) {
            e.printStackTrace();
            String errInfo = ExceptionUtil.getExceptionMessage(e);
            return AjaxResult.error(errInfo);
        }
    }

    @Override
    public AjaxResult addSxtptgj(ZhsqSxtptgj zhsqSxtptgj) {
        try {

            String sxtid = zhsqSxtptgj.getDeviceCode();
            if (Strings.isBlank(sxtid)) {
                return AjaxResult.error(CommunityConstants.NO_SXTID_CODE);
            }
            ZhsqSxt zhsqSxt = zhsqSxtService.selectZhsqSxtById(sxtid);
            if (Objects.isNull(zhsqSxt)) {
                return AjaxResult.error(CommunityConstants.NO_SXTID_CODE);
            }

            int affectNum = zhsqYcService.insertZhsqSxtpugj(zhsqSxtptgj);
            if (affectNum > 0) {
                return AjaxResult.success();
            }
            return AjaxResult.error(CommunityConstants.AFFECT_ZERO);
        } catch (Exception e) {
            e.printStackTrace();
            String errInfo = ExceptionUtil.getExceptionMessage(e);
            return AjaxResult.error(errInfo);
        }
    }

    @Override
    public AjaxResult addSxtrlbkgj(ZhsqSxtrlbkgj zhsqSxtrlbkgj) {
        try {
            String sxtid = zhsqSxtrlbkgj.getFacecamCode();
            if (Strings.isBlank(sxtid)) {
                return AjaxResult.error(CommunityConstants.NO_SXTID_CODE);
            }
            ZhsqSxt zhsqSxt = zhsqSxtService.selectZhsqSxtById(sxtid);
            if (Objects.isNull(zhsqSxt)) {
                return AjaxResult.error(CommunityConstants.NO_SXTID_CODE);
            }

            int affectNum = zhsqYcService.insertZhsqSxtrlbkgj(zhsqSxtrlbkgj);
            if (affectNum > 0) {
                return AjaxResult.success();
            }
            return AjaxResult.error(CommunityConstants.AFFECT_ZERO);
        } catch (Exception e) {
            e.printStackTrace();
            String errInfo = ExceptionUtil.getExceptionMessage(e);
            return AjaxResult.error(errInfo);
        }
    }

}
