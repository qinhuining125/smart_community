package com.feather.community.service;

import com.feather.community.domain.ZhsqCl;
import com.feather.community.domain.ZhsqClJc;

import java.util.List;

/**
 * 车辆进出Service接口
 * 
 * @author fancy
 * @date 2020-05-15
 */
public interface IZhsqClJcService {

    /**
     * 查询车辆列表
     * 
     * @param zhsqClJc
     *            车辆
     * @return 车辆集合
     */
    public List<ZhsqClJc> selectZhsqClList(ZhsqClJc hsqClJc);
}
