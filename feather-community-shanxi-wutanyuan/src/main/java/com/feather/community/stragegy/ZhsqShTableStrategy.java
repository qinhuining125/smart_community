package com.feather.community.stragegy;

import com.feather.common.core.page.TableDataInfo;
import com.feather.community.domain.ZhsqSh;
import com.feather.community.domain.ZhsqYc;
import com.feather.community.pojo.SearchEntity;
import com.feather.community.service.IZhsqShService;
import com.feather.community.service.IZhsqYcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-16 11:52
 * @description 硬件手环查询策略
 */
@Component
public class ZhsqShTableStrategy extends AbstraceTableStrategy {
    @Autowired
    IZhsqShService zhsqShService;

    @Override
    public TableDataInfo tableQueryStrategy(SearchEntity searchEntity) {
        ZhsqSh zhsqSh=new ZhsqSh();
        List<ZhsqSh> zhsqShs = zhsqShService.selectZhsqShList(zhsqSh);
        TableDataInfo tableDataInfo = getDataTable(zhsqShs);
        return tableDataInfo;
    }
}
