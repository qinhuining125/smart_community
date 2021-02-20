package com.feather.community.stragegy;

import com.feather.common.core.page.TableDataInfo;
import com.feather.community.domain.ZhsqFw;
import com.feather.community.domain.ZhsqJm;
import com.feather.community.pojo.SearchEntity;
import com.feather.community.service.IZhsqFwService;
import com.feather.community.service.IZhsqJmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-16 14:10
 * @description 房屋查询策略
 */
@Component
public class ZhsqFwTableStrategy extends AbstraceTableStrategy {
    @Autowired
    IZhsqFwService zhsqFwService;
    @Autowired
    IZhsqJmService zhsqJmService;


    @Override
    public TableDataInfo tableQueryStrategy(SearchEntity searchEntity) {
        ZhsqFw zhsqFw = new ZhsqFw();
        zhsqFw.setLdid(searchEntity.getLdid());
        zhsqFw.setLdmc(searchEntity.getName());
        zhsqFw.setMph(searchEntity.getMph());
        zhsqFw.setFwrzqk(searchEntity.getFwrzqk());
        zhsqFw.setDy(searchEntity.getDy());
        List<ZhsqFw> zhsqFws = zhsqFwService.selectZhsqFwList(zhsqFw);
        List<ZhsqFw> cc=new ArrayList<ZhsqFw>();
       //添加居民信息
        for(int i=0;i<zhsqFws.size();i++){
            ZhsqFw entity=zhsqFws.get(i);
            ZhsqJm zhsqJm=new ZhsqJm();
            zhsqJm.setFwid(entity.getFwid());
            List<ZhsqJm> ls=zhsqJmService.selectZhsqJmList(zhsqJm);
            entity.setZhsqJms(ls);
            zhsqFws.set(i,entity);
        }
        TableDataInfo tableDataInfo = getDataTable(zhsqFws);
        return tableDataInfo;
    }
}
