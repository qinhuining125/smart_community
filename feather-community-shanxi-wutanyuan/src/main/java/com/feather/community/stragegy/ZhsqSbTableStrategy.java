package com.feather.community.stragegy;

import com.feather.common.core.page.TableDataInfo;
import com.feather.community.domain.ZhsqSb;
import com.feather.community.domain.ZhsqSh;
import com.feather.community.pojo.SearchEntity;
import com.feather.community.service.IZhsqSbService;
import com.feather.community.service.IZhsqShService;
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
public class ZhsqSbTableStrategy extends AbstraceTableStrategy {
    @Autowired
    IZhsqSbService zhsqSbService;

    @Override
    public TableDataInfo tableQueryStrategy(SearchEntity searchEntity) {
        ZhsqSb zhsqSb=new ZhsqSb();
        zhsqSb.setSbmc(searchEntity.getName());
        List<ZhsqSb> zhsqSbs = zhsqSbService.selectZhsqSbList(zhsqSb);
        TableDataInfo tableDataInfo = getDataTable(zhsqSbs);
        return tableDataInfo;
    }
}
