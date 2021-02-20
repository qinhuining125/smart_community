package com.feather.community.service.impl;

import com.feather.common.core.text.Convert;
import com.feather.community.domain.ZhsqCl;
import com.feather.community.domain.ZhsqClJc;
import com.feather.community.mapper.ZhsqClJcMapper;
import com.feather.community.mapper.ZhsqClMapper;
import com.feather.community.service.IZhsqClJcService;
import com.feather.community.service.IZhsqClService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 车辆进出Service业务层处理
 * 
 * @author fancy
 * @date 2020-05-15
 */
@Service
public class ZhsqClJcServiceImpl implements IZhsqClJcService {
    @Autowired
    private ZhsqClJcMapper zhsqClJcMapper;


    /**
     * 查询车辆列表
     * 
     * @param zhsqClJc
     *            车辆
     * @return 车辆
     */
    @Override
    public List<ZhsqClJc> selectZhsqClList(ZhsqClJc zhsqClJc) {

        return zhsqClJcMapper.selectZhsqClJcList(zhsqClJc);
    }


}
