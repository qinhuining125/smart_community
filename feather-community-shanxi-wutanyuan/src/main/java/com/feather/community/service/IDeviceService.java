package com.feather.community.service;

import com.feather.common.core.domain.AjaxResult;
import com.feather.community.domain.*;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-14 17:33
 * @description 设备service
 */
public interface IDeviceService {

    /**
     * 增加手环
     * @param zhsqSh
     * @return
     */
    AjaxResult addSh(ZhsqSh zhsqSh);

    /**
     * 增加手环日志
     * @param zhsqShrz
     * @return
     */
    AjaxResult addShrz(ZhsqShrz zhsqShrz);
    /**
     * 增加水表日志
     * @param zhsqSbrz
     * @return
     */
    AjaxResult addSbrz(ZhsqSbrz zhsqSbrz);
    /**
     * 增加烟感日志
     * @param zhsqYgrz
     * @return
     */
    AjaxResult addYgrz(ZhsqYgrz zhsqYgrz);
    /**
     * 增加摄像头普通告警
     * @param zhsqSxtptgj
     * @return
     */
    AjaxResult addSxtptgj(ZhsqSxtptgj zhsqSxtptgj);
}
