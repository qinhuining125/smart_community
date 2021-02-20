package com.feather.community.stragegy;

import com.feather.common.core.page.TableDataInfo;
import com.feather.community.domain.ZhsqCl;
import com.feather.community.domain.ZhsqClJc;
import com.feather.community.pojo.SearchEntity;
import com.feather.community.service.IZhsqClJcService;
import com.feather.community.service.IZhsqClService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-16 14:18
 * @description 车辆进出查询策略
 */
@Component
public class ZhsqClJcTableStrategy extends AbstraceTableStrategy {
    @Autowired
    IZhsqClJcService zhsqClJcService;

    @Override
    public TableDataInfo tableQueryStrategy(SearchEntity searchEntity) {
        //换张表进行查询
        ZhsqClJc zhsqClJc = new ZhsqClJc();
        zhsqClJc.setClhm(searchEntity.getName());
        zhsqClJc.setCx(searchEntity.getCx());
        zhsqClJc.setCllx(searchEntity.getCllx());
        List<ZhsqClJc> zhsqClJcs = zhsqClJcService.selectZhsqClList(zhsqClJc);
        TableDataInfo tableDataInfo = getDataTable(zhsqClJcs);
        return tableDataInfo;
    }
}
