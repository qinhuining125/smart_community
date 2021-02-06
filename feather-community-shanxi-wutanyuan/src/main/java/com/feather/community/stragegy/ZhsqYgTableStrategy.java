package com.feather.community.stragegy;

import com.feather.common.core.page.TableDataInfo;
import com.feather.community.domain.ZhsqSh;
import com.feather.community.domain.ZhsqYg;
import com.feather.community.pojo.SearchEntity;
import com.feather.community.service.IZhsqShService;
import com.feather.community.service.IZhsqYgService;
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
public class ZhsqYgTableStrategy extends AbstraceTableStrategy {
    @Autowired
    IZhsqYgService zhsqYgService;

    @Override
    public TableDataInfo tableQueryStrategy(SearchEntity searchEntity) {
        ZhsqYg zhsqYg=new ZhsqYg();
        zhsqYg.setSbmc(searchEntity.getName());
        List<ZhsqYg> zhsqYgs = zhsqYgService.selectZhsqYgList(zhsqYg);
        TableDataInfo tableDataInfo = getDataTable(zhsqYgs);
        return tableDataInfo;
    }
}
