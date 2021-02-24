package com.feather.community.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.druid.proxy.jdbc.ClobProxyImpl;
import com.feather.common.core.page.TableDataInfo;
import com.feather.community.domain.ZhsqJm;
import com.feather.community.domain.ZhsqSh;
import com.feather.community.domain.ZhsqShrz;
import com.feather.community.service.IZhsqShService;
import com.feather.community.service.IZhsqShrzService;
import com.feather.community.util.MyTableDataInfo;
import com.feather.system.service.ISysDictDataService;
import com.feather.system.service.ISysDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feather.common.core.controller.BaseController;
import com.feather.common.core.domain.AjaxResult;
import com.feather.community.service.IZhsqZcService;
import com.feather.community.service.IZhsqZhzlService;

import io.lettuce.core.dynamic.annotation.Param;

/**
 * 综合治理
 * 
 * @author fancy
 * @date 2020-05-14
 */
@Controller
@RequestMapping("/zhzl")
public class ZhsqZhzlController extends BaseController {
    @Autowired
    private IZhsqZhzlService zhsqZhzlService;
    @Autowired
    private IZhsqZcService zhsqZcService;
    @Autowired
    private IZhsqShrzService zhsqShrzService;
    @Autowired
    private IZhsqShService zhsqShService;
    @Autowired
    private ISysDictDataService sysDictDataService;



    @GetMapping("/api/selectZdryCount")
    @ResponseBody
    public AjaxResult selectZdryCount(@Param("xqid") String xqid, @Param("sqid") String sqid) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("xqid", xqid);
        maps.put("sqid", sqid);
        return AjaxResult.success(zhsqZhzlService.selectZdryCount(maps));
    }

    /**
     * 统计重点人员分布情况
     * 
     * @return
     */
    @GetMapping("/api/getZdryFb")
    @ResponseBody
    public AjaxResult getZdryFb(@Param("xqid") String xqid, @Param("sqid") String sqid, @Param("sfdj") String sfdj,
            @Param("sfkc") String sfkc, @Param("sfxmsf") String sfxmsf, @Param("sftyjr") String sftyjr,
            @Param("sfdb") String sfdb, @Param("sfcj") String sfcj) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("xqid", xqid);
        maps.put("sqid", sqid);
        maps.put("sfdj", sfdj);
        maps.put("sfkc", sfkc);
        maps.put("sfxmsf", sfxmsf);
        maps.put("sftyjr", sftyjr);
        maps.put("sfdb", sfdb);
        maps.put("sfcj", sfcj);

        return AjaxResult.success(zhsqZhzlService.getZdryFb(maps));
    }

    /**
     * 统计重点人员年龄结构
     * 
     * @return
     */
    @GetMapping("/api/getZdNl")
    @ResponseBody
    public AjaxResult getZdNl(@Param("xqid") String xqid, @Param("sqid") String sqid, @Param("sfdj") String sfdj,
            @Param("sfkc") String sfkc, @Param("sfxmsf") String sfxmsf, @Param("sftyjr") String sftyjr,
            @Param("sfdb") String sfdb, @Param("sfcj") String sfcj) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("xqid", xqid);
        maps.put("sqid", sqid);
        maps.put("sfdj", sfdj);
        maps.put("sfkc", sfkc);
        maps.put("sfxmsf", sfxmsf);
        maps.put("sftyjr", sftyjr);
        maps.put("sfdb", sfdb);
        maps.put("sfcj", sfcj);
        return AjaxResult.success(zhsqZhzlService.getZdNl(maps));
    }

    /**
     * 统计重点人员男女比例
     * 
     * @return
     */
    @GetMapping("/api/getZdNnBl")
    @ResponseBody
    public AjaxResult getZdNnBl(@Param("xqid") String xqid, @Param("sqid") String sqid, @Param("sfdj") String sfdj,
            @Param("sfkc") String sfkc, @Param("sfxmsf") String sfxmsf, @Param("sftyjr") String sftyjr,
            @Param("sfdb") String sfdb, @Param("sfcj") String sfcj) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("xqid", xqid);
        maps.put("sqid", sqid);
        maps.put("sfdj", sfdj);
        maps.put("sfkc", sfkc);
        maps.put("sfxmsf", sfxmsf);
        maps.put("sftyjr", sftyjr);
        maps.put("sfdb", sfdb);
        maps.put("sfcj", sfcj);
        return AjaxResult.success(zhsqZhzlService.getZdNnBl(maps));
    }

    /**
     * 统计重点人员民族比例
     * 
     * @return
     */
    @GetMapping("/api/getZdMzBl")
    @ResponseBody
    public AjaxResult getZdMzBl(@Param("xqid") String xqid, @Param("sqid") String sqid, @Param("sfdj") String sfdj,
            @Param("sfkc") String sfkc, @Param("sfxmsf") String sfxmsf, @Param("sftyjr") String sftyjr,
            @Param("sfdb") String sfdb, @Param("sfcj") String sfcj) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("xqid", xqid);
        maps.put("sqid", sqid);
        maps.put("sfdj", sfdj);
        maps.put("sfkc", sfkc);
        maps.put("sfxmsf", sfxmsf);
        maps.put("sftyjr", sftyjr);
        maps.put("sfdb", sfdb);
        maps.put("sfcj", sfcj);
        return AjaxResult.success(zhsqZhzlService.getZdMzBl(maps));
    }

    /**
     * 重点人员列表
     * 
     * @return
     */
    @GetMapping("/api/getZdRyList")
    @ResponseBody
    public MyTableDataInfo getZdRyList(@Param("xqid") String xqid, @Param("sqid") String sqid, @Param("sfdj") String sfdj,
            @Param("sfkc") String sfkc, @Param("sfxmsf") String sfxmsf, @Param("sftyjr") String sftyjr,
            @Param("sfdb") String sfdb, @Param("sfcj") String sfcj, @Param("zdry") String zdry) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("xqid", xqid);
        maps.put("sqid", sqid);
        maps.put("sfdj", sfdj);
        maps.put("sfkc", sfkc);
        maps.put("sfxmsf", sfxmsf);
        maps.put("sftyjr", sftyjr);
        maps.put("sfdb", sfdb);
        maps.put("sfcj", sfcj);
        maps.put("zdry", zdry);

        startPage();
        List<Map<String, Object>> list = zhsqZhzlService.getZdRyList(maps);
        TableDataInfo tableDataInfo = getDataTable(list);
        MyTableDataInfo myTableDataInfo = new MyTableDataInfo(tableDataInfo);
        return myTableDataInfo;
       // return AjaxResult.success(zhsqZhzlService.getZdRyList(maps));
    }

    /**
     * 人员佩带手环信息
     *
     * @return
     */
    @GetMapping("/api/getRyShInfo")
    @ResponseBody
    public AjaxResult getRyShInfo(@Param("jmid") String jmid) {
        Map<String, Object> maps = new HashMap<>();
        ZhsqSh zhsqSh=new ZhsqSh();
        zhsqSh.setJmid(jmid);
        List<ZhsqSh> ls=zhsqShService.selectZhsqShList(zhsqSh);
        maps.put("flag",false);
        if(ls!=null&&ls.size()>0){
            maps.put("flag",true);
            String shid=ls.get(0).getShid();
            ZhsqShrz zhsqShrz=new ZhsqShrz();
            zhsqShrz.setShid(shid);
            List<ZhsqShrz> shrzlist=zhsqShrzService.selectZhsqShrzList(zhsqShrz);
            if(shrzlist!=null && shrzlist.size()>0 ){
                maps.put("shxx", shrzlist.get(0));
                //添加手环报警信息进入
                String alarmConent=sysDictDataService.selectDictLabel("zhsq_shjg",shrzlist.get(0).getAlarmState());
                if(alarmConent==null){
                    alarmConent="";
                }
                shrzlist.get(0).setAlarmContent(alarmConent);
            }
        }
        return AjaxResult.success(maps);
    }

    /**
     * 巡检任务统计
     * 
     * @return
     */
    @GetMapping("/api/selectXjrwCount")
    @ResponseBody
    public AjaxResult selectXjrwCount(@Param("xqid") String xqid, @Param("sqid") String sqid) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("xqid", xqid);
        maps.put("sqid", sqid);
        return AjaxResult.success(zhsqZhzlService.selectXjrwCount(maps));
    }

    /**
     * 首页人员巡检
     * 
     * @return
     */
    @GetMapping("/api/selectRyxjCount")
    @ResponseBody
    public AjaxResult selectRyxjCount(@Param("xqid") String xqid, @Param("sqid") String sqid) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("xqid", xqid);
        maps.put("sqid", sqid);
        return AjaxResult.success(zhsqZhzlService.selectRyxjCount(maps));
    }

    // 小区树
    @RequestMapping("/api/getTree")
    @ResponseBody
    public AjaxResult getTree() {
        List<Map> listSq = zhsqZcService.getSqAreaTree();
        List<Map> listSq1 = new ArrayList<>();
        Map map1 = null;
        for (Map map : listSq) {
            map1 = new HashMap();
            map1.put("id", map.get("SQID").toString());
            map1.put("name", map.get("SQMC").toString());
            map1.put("pId", "0");
            map1.put("open", true);

            List<Map> listxq = zhsqZcService.getAreaTree(map.get("SQID").toString());
            List<Map> lista = new ArrayList<>();
            for (Map map2 : listxq) {
                Map map3 = new HashMap();
                map3.put("id", map2.get("XQID").toString());
                map3.put("name", map2.get("XQMC").toString());
                map3.put("pId", map2.get("SQID").toString());
                map3.put("open", true);
                map3.put("children", "");
                lista.add(map3);
            }
            map1.put("children", lista);
        }
        listSq1.add(map1);

        return AjaxResult.success(listSq1);
    }

    /**
     * 巡检任务
     * 
     * @return
     */
    @GetMapping("/api/getXjrw")
    @ResponseBody
    public AjaxResult getXjrw(@Param("xqid") String xqid, @Param("sqid") String sqid, @Param("xczt") String xczt,
            @Param("xjrw") String xjrw) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("xqid", xqid);
        maps.put("sqid", sqid);
        maps.put("xczt", xczt);
        maps.put("xjrw", xjrw);
        return AjaxResult.success(zhsqZhzlService.getXjrw(maps));
    }

    /**
     * 重点事件
     * 
     * @return
     */
    @GetMapping("/api/selectZdsjCount")
    @ResponseBody
    public AjaxResult selectZdsjCount(@Param("xqid") String xqid, @Param("sqid") String sqid) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("xqid", xqid);
        maps.put("sqid", sqid);
        return AjaxResult.success(zhsqZhzlService.selectZdsjCount(maps));
    }

    /**
     * 重点事件扇形图
     * 
     * @return
     */
    @GetMapping("/api/selectZdsjTCount")
    @ResponseBody
    public AjaxResult selectZdsjTCount(@Param("xqid") String xqid, @Param("sqid") String sqid) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("xqid", xqid);
        maps.put("sqid", sqid);
        return AjaxResult.success(zhsqZhzlService.selectZdsjTCount(maps));
    }

    /**
     * 重点事件列表
     * 
     * @return
     */
    @GetMapping("/api/getZdsjList")
    @ResponseBody
    public AjaxResult getZdsjList(@Param("page") Integer page,@Param("page")  Integer size, @Param("xqid") String xqid, @Param("sqid") String sqid, @Param("czzt") String czzt,
            @Param("sjlx") String sjlx)throws SQLException {
        Map<String, Object> maps = new HashMap<>();
        maps.put("page", page);
        maps.put("size", size);
        maps.put("xqid", xqid);
        maps.put("sqid", sqid);
        maps.put("czzt", czzt);
        maps.put("sjlx", sjlx);
        List<Map<String, Object>> ycList = zhsqZhzlService.getZdsjList(maps);
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> resultMap = new HashMap<>();
       Integer ii= zhsqZhzlService.getZdsjCount(maps);
        resultMap.put("total", zhsqZhzlService.getZdsjCount(maps));
        for (int i = 0; i < ycList.size(); i++) {
            Map<String, Object> map = ycList.get(i);
            Object ycxw = map.get("YCNR");
            if (ycxw instanceof ClobProxyImpl) {
                ycxw = ((ClobProxyImpl) ycxw).getSubString(1, (int) ((ClobProxyImpl) ycxw).length());
            }
            Map<String, Object> map1 = new HashMap<>();
            map1.put("YCID", String.valueOf(map.get("YCID")));
            map1.put("YCSJ", String.valueOf(map.get("YCSJ")));
            map1.put("YCNR", ycxw);
            map1.put("YCJB", String.valueOf(map.get("YCJB")));
            map1.put("CZZT", String.valueOf(map.get("CZZT")));
            map1.put("YCLY", String.valueOf(map.get("YCLY")));
            map1.put("SJLX", String.valueOf(map.get("SJLX")));
            list.add(map1);
        }
        resultMap.put("rows", list);
        return AjaxResult.success(resultMap);
    }
}
