package com.feather.community.mapper;

import java.util.List;

import com.feather.community.domain.ZhsqCl;
import com.feather.community.domain.ZhsqClJc;

/**
 * 车辆记录Mapper接口
 *
 * @author fancy
 * @date 2020-05-15
 */
public interface ZhsqClJcMapper {


    /**
     * 查询车辆列表
     *
     * @param zhsqCl
     *            车辆
     * @return 车辆集合
     */
    public List<ZhsqClJc> selectZhsqClJcList(ZhsqClJc zhsqClJc);

}
