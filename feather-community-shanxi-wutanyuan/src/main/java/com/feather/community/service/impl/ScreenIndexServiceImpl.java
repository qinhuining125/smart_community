package com.feather.community.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.feather.common.config.UidWorker;
import com.feather.common.core.page.TableDataInfo;
import com.feather.community.domain.*;
import com.feather.community.pojo.SearchEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.feather.common.core.domain.AjaxResult;
import com.feather.common.utils.ExceptionUtil;
import com.feather.community.pojo.ResultEntity;
import com.feather.community.util.MathUtil;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-10 16:23
 * @description 统计service
 */
@Service
public class ScreenIndexServiceImpl extends AbstractScreenIndexService {

    @Autowired
    private UidWorker uidWorker;

    @Override
    public AjaxResult getSfczTj(Map<String, Object> params) {
        Map<String, String> result = new HashMap<>(16);
        try {
            params.put("czrk", "是");
            params.put("wlrk", "否");
            List<Map<String, String>> sfcz = screenIndexMapper.getSfczTj(params);
            if (sfcz != null && sfcz.size() > 0) {
                for (Map<String, String> map : sfcz) {
                    String res = map.get("sl");
                    String[] arr = res.split(",");
                    result.put(arr[0], arr[1]);
                }
            }
            return AjaxResult.success(parseToFrontResult("sqglry", result));
        } catch (Exception e) {
            e.printStackTrace();
            String errInfo = ExceptionUtil.getExceptionMessage(e);
            return AjaxResult.error(errInfo);
        }
    }

    @Override
    public AjaxResult sqglJmTj(Map<String, Object> params) {
        Map<String, ResultEntity> result = new HashMap<>(8);
        try {
            Map<String, String> map = new HashMap<>(8);
            map.put("nl", "getNljgTjByJm");
            map.put("xb", "getXbTjByJm");
            map.put("mz", "getMzTjByJm");
            addTjResultToMapByDynamicMethod(params, map, result);
            return AjaxResult.success(result);
        } catch (Exception e) {
            e.printStackTrace();
            String errInfo = ExceptionUtil.getExceptionMessage(e);
            return AjaxResult.error(errInfo);
        }
    }

    @Override
    public AjaxResult sqglFwTj() {
        Map<String, String> result = new HashMap<>(16);
        try {
            List<Map<String, String>> fwtj = zhsqFwService.sqglFwTj();
            if (fwtj != null && fwtj.size() > 0) {
                for (Map<String, String> map : fwtj) {
                    String res = map.get("sl");
                    String[] arr = res.split(",");
                    result.put(arr[0], arr[1]);
                }
                // 入住率
                String rzlbfb = MathUtil.getPercent(result, "rz", "fwzs");
                result.put("rzl", result.get("rz"));
                result.put("rzlbfb", rzlbfb);
                // 商业百分比
                String sybfb = MathUtil.getPercent(result, "sy", "fwzs");
                result.put("sybfb", sybfb);
                // 住宅百分比
                String zzbfb = MathUtil.getPercent(result, "zz", "fwzs");
                result.put("zzbfb", zzbfb);
                // 其他百分比
                String qtbfb = MathUtil.getPercent(result, "qt", "fwzs");
                result.put("qtbfb", qtbfb);
                // 自有百分比
                String zybfb = MathUtil.getPercent(result, "zy", "fwzs");
                result.put("zybfb", zybfb);
                // 出租百分比
                String czbfb = MathUtil.getPercent(result, "cz", "fwzs");
                result.put("czbfb", czbfb);
            }
            return AjaxResult.success(parseToFrontResult("sqglfw", result));
        } catch (Exception e) {
            e.printStackTrace();
            String errInfo = ExceptionUtil.getExceptionMessage(e);
            return AjaxResult.error(errInfo);
        }
    }

    @Override
    public AjaxResult sqglSbTj() {
        int sxtzs=0;
        int sbzs=0;
        int zjzs=0;
        int dgzs=0;
        int jgzs=0;
        int shzs=0;
        int ygzs=0;
        int sxtlx=0;
        int sblx=0;
        int shlx=0;
        int zjlx=0;
        int jglx=0;
        int dglx=0;
        int yglx=0;
        Map<String, String> result = new HashMap<>(16);
        Map<String, Object> result2 = new HashMap<>(16);
        try {
            List<Map<String, String>> sbtj = screenIndexMapper.sqglSbTj();
            if (sbtj != null && sbtj.size() > 0) {
                for (Map<String, String> map : sbtj) {
                    String res = map.get("sl");
                    String[] arr = res.split(",");
                    result.put(arr[0], arr[1]);
                }
                for (Map.Entry<String, String> entry : result.entrySet()) {
                    String mapKey = entry.getKey();
                    String mapValue = entry.getValue();
                    int mapValueInt = Integer.parseInt(mapValue);
                    if(mapKey.equals("sxtzx")||mapKey.equals("sxtlx")){
                        sxtzs+=mapValueInt;
                        if(mapKey.equals("sxtlx")){
                            sxtlx=mapValueInt;
                        }
                    }
                    if(mapKey.equals("sbzx")||mapKey.equals("sblx")){
                        sbzs+=mapValueInt;
                        if(mapKey.equals("sblx")){
                            sblx=mapValueInt;
                        }
                    }
                    if(mapKey.equals("zjzx")||mapKey.equals("zjlx")){
                        zjzs+=mapValueInt;
                        if(mapKey.equals("zjlx")){
                            zjlx=mapValueInt;
                        }
                    }
                    if(mapKey.equals("dgzx")||mapKey.equals("dglx")){
                        dgzs+=mapValueInt;
                        if(mapKey.equals("dglx")){
                            dglx=mapValueInt;
                        }
                    }
                    if(mapKey.equals("jgzx")||mapKey.equals("jglx")){
                        jgzs+=mapValueInt;
                        if(mapKey.equals("jglx")){
                            jglx=mapValueInt;
                        }
                    }
                    if(mapKey.equals("shzx")||mapKey.equals("shlx")){
                        shzs+=mapValueInt;
                        if(mapKey.equals("shlx")){
                            shlx=mapValueInt;
                        }
                    }
                    if(mapKey.equals("ygzx")||mapKey.equals("yglx")){
                        ygzs+=mapValueInt;
                        if(mapKey.equals("yglx")){
                            yglx=mapValueInt;
                        }
                    }
                }
                List<Map> list=new ArrayList<>();
                //摄像头
                Map mapsxt=new HashMap();
                mapsxt.put("id","01");
                mapsxt.put("name","摄像头");
                mapsxt.put("abNormal",sxtlx);
                mapsxt.put("allNumber",sxtzs);
                list.add(mapsxt);
                //水表
                Map mapsb=new HashMap();
                mapsb.put("id","02");
                mapsb.put("name","水表");
                mapsb.put("abNormal",sblx);
                mapsb.put("allNumber",sbzs);
                list.add(mapsb);
                //闸机
                Map mapzj=new HashMap();
                mapzj.put("id","03");
                mapzj.put("name","闸机");
                mapzj.put("abNormal",zjlx);
                mapzj.put("allNumber",zjzs);
                list.add(mapzj);
                //导杆
                Map mapdg=new HashMap();
                mapdg.put("id","04");
                mapdg.put("name","道杆");
                mapdg.put("abNormal",dglx);
                mapdg.put("allNumber",dgzs);
                list.add(mapdg);
                //井盖
                Map mapjg=new HashMap();
                mapjg.put("id","05");
                mapjg.put("name","井盖");
                mapjg.put("abNormal",jglx);
                mapjg.put("allNumber",jgzs);
                list.add(mapjg);
                //手环
                Map mapsh=new HashMap();
                mapsh.put("id","06");
                mapsh.put("name","手环");
                mapsh.put("abNormal",shlx);
                mapsh.put("allNumber",shzs);
                list.add(mapsh);
                //烟感
                Map mapyg=new HashMap();
                mapyg.put("id","07");
                mapyg.put("name","烟感");
                mapyg.put("abNormal",yglx);
                mapyg.put("allNumber",ygzs);
                list.add(mapyg);
                result2.put("equipmentList",list);
            }
            return AjaxResult.success(result2);
        } catch (Exception e) {
            e.printStackTrace();
            String errInfo = ExceptionUtil.getExceptionMessage(e);
            return AjaxResult.error(errInfo);
        }
    }

    @Override
    public AjaxResult zhdjTj(Map<String, Object> params) {
        Map<String, ResultEntity> result = new HashMap<>(8);
        try {
            ResultEntity resultEntity = getDzdwTjResultEntity(params);
            result.put("dzdw", resultEntity);

            Map<String, String> map = new HashMap<>(8);
            map.put("xl", "getDyxlfbTj");
            /*map.put("nl", "getDynlfbTj");
            map.put("xb", "getDyxbblTj");
            map.put("mz", "getDymzblTj");*/
            map.put("dl", "getDydlfbTj");
            addTjResultToMapByDynamicMethod(params, map, result);
            return AjaxResult.success(result);
        } catch (Exception e) {
            e.printStackTrace();
            String errInfo = ExceptionUtil.getExceptionMessage(e);
            return AjaxResult.error(errInfo);
        }
    }

    @Override
    public AjaxResult zhzlZdryTj(Map<String, Object> params) {
        Map<String, ResultEntity> result = new HashMap<>(8);
        try {
            ResultEntity resultEntity = getZdryrzTjResultEntity(params);
            result.put("zdry", resultEntity);

            Map<String, String> map = new HashMap<>(8);
            map.put("zdryfb", "getZdryfbTj");
            map.put("nl", "getNljgTjByJm");
            map.put("xb", "getXbTjByJm");
            map.put("mz", "getMzTjByJm");
            addTjResultToMapByDynamicMethod(params, map, result);
            return AjaxResult.success(result);
        } catch (Exception e) {
            e.printStackTrace();
            String errInfo = ExceptionUtil.getExceptionMessage(e);
            return AjaxResult.error(errInfo);
        }
    }

    @Override
    public TableDataInfo searZhsqListByType(SearchEntity searchEntity) {
        int type = searchEntity.getType();
        switch(type){
            case 1:
                tableStrategyContext.setTableStrategy(zhsqLdTableStrategy);
                break;
            case 2:
                tableStrategyContext.setTableStrategy(zhsqFwTableStrategy);
                break;
            case 4:
                tableStrategyContext.setTableStrategy(zhsqClTableStrategy);
                break;
            case 5:
                tableStrategyContext.setTableStrategy(zhsqDzzTableStrategy);
                break;
            case 6:
                tableStrategyContext.setTableStrategy(zhsqDyTableStrategy);
                break;
            case 7: //硬件异常
                tableStrategyContext.setTableStrategy(zhsqYcTableStrategy);
                break;
            case 8: //设备-手环
                tableStrategyContext.setTableStrategy(zhsqShTableStrategy);
                break;
            case 9: //设备-水表
                tableStrategyContext.setTableStrategy(zhsqSbTableStrategy);
                break;
            case 10: //设备-烟感
                tableStrategyContext.setTableStrategy(zhsqYgTableStrategy);
                break;
            case 11:
                tableStrategyContext.setTableStrategy(zhsqClJcTableStrategy);
                break;
            default:
                tableStrategyContext.setTableStrategy(zhsqJmTableStrategy);
        }
        TableDataInfo tableDataInfo = tableStrategyContext.handle(searchEntity);
        return tableDataInfo;
    }

    @Override
    public TableDataInfo searchLdList(ZhsqLd zhsqLd) {
        List<ZhsqLd> zhsqLds = zhsqLdService.selectZhsqLdList(zhsqLd);
        List<String> ldids = zhsqLds.stream().map(ZhsqLd::getLdid).collect(Collectors.toList());
        if (ldids != null && ldids.size() > 0) {
            List<ZhsqFw> zhsqFws = zhsqFwService.selectZhsqFwByLdids(ldids);
            Map<String, Map<String, List<ZhsqFw>>> zhsqFwMapList = zhsqFws.stream().collect(Collectors.groupingBy(ZhsqFw::getLdid, Collectors.groupingBy(ZhsqFw::getDy)));

            for (ZhsqLd zhsqLd1 : zhsqLds) {
                String ldid = zhsqLd1.getLdid();
                List<ZhsqLdVo> ls=new ArrayList<ZhsqLdVo>();
                Map<String, List<ZhsqFw>> zhsqFwListMap = zhsqFwMapList.get(ldid);
                for(String key : zhsqFwListMap.keySet()){
                    ZhsqLdVo  zhsqLdVo=new ZhsqLdVo();
                    zhsqLdVo.setDyh(key+"单元");
                    zhsqLdVo.setLdid(ldid);
                    zhsqLdVo.setZhsqFws(zhsqFwListMap.get(key));
                    ls.add(zhsqLdVo);
                }
                if (zhsqFwListMap != null) {
                    zhsqLd1.setZhsqFwListMap(ls);
                }
            }
        }
        TableDataInfo tableDataInfo = getDataTable(zhsqLds);
        return tableDataInfo;
    }

    @Override
    public List<ZhsqYgVo> searchYgList(ZhsqLd zhsqLd) {
        //数据结构，
        List<ZhsqYgVo> resultList=new ArrayList<ZhsqYgVo>();
        //1.查询出楼栋信息
        List<ZhsqLd> zhsqLds = zhsqLdService.selectZhsqLdList(zhsqLd);
        List<String> ldids = zhsqLds.stream().map(ZhsqLd::getLdid).collect(Collectors.toList());
        if (ldids != null && ldids.size() > 0) {
            List<ZhsqFw> zhsqFws = zhsqFwService.selectZhsqFwByLdids(ldids);
            Map<String, Map<String, List<ZhsqFw>>> zhsqFwMapList = zhsqFws.stream().collect(Collectors.groupingBy(ZhsqFw::getLdid, Collectors.groupingBy(ZhsqFw::getDy)));
            for (ZhsqLd zhsqLd1 : zhsqLds) {
                String ldid = zhsqLd1.getLdid();
                Map<String, List<ZhsqFw>> zhsqFwListMap = zhsqFwMapList.get(ldid);
                for(String key : zhsqFwListMap.keySet()){
                    ZhsqYgVo  zhsqYgVo=new ZhsqYgVo();
                    zhsqYgVo.setDyh(key+"单元");
                    zhsqYgVo.setLdid(ldid);
                    //需要查询烟感的信息
                    ZhsqYg zhsqYg=new ZhsqYg();
                    zhsqYg.setLdid(ldid);
                    zhsqYg.setDy(key);
                    //随机生成这些单元id
                    zhsqYgVo.setDyid("DY" + uidWorker.getNextId());
                    List<ZhsqYg> zhsqYgs = zhsqYgService.selectZhsqYgList(zhsqYg);
                    zhsqYgVo.setZhsqYgs(zhsqYgs);
                    if(zhsqYgs!=null && !zhsqYgs.isEmpty()){
                        zhsqYgVo.setX(zhsqYgs.get(0).getX());
                        zhsqYgVo.setY(zhsqYgs.get(0).getY());
                        resultList.add(zhsqYgVo);
                    }
                }
            }
        }
        return resultList;
    }
}