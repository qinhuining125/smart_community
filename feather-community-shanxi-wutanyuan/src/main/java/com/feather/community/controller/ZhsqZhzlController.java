package com.feather.community.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.druid.proxy.jdbc.ClobProxyImpl;
import com.feather.common.annotation.Log;
import com.feather.common.core.page.TableDataInfo;
import com.feather.common.enums.BusinessType;
import com.feather.community.domain.*;
import com.feather.community.service.*;
import com.feather.community.util.MyTableDataInfo;
import com.feather.system.service.ISysDictDataService;
import com.feather.system.service.ISysDictTypeService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.feather.common.core.controller.BaseController;
import com.feather.common.core.domain.AjaxResult;

import io.lettuce.core.dynamic.annotation.Param;
import com.feather.community.domain.ZhsqJmrwgh;
import com.feather.community.service.IZhsqJmrwghService;

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
    @Autowired
    private IZhsqSxtrlbkgjService zhsqSxtrlbkgjService;
    @Autowired
    private IZhsqYcService zhsqYcService;

    @Autowired
    private IZhsqJmrwghService zhsqJmrwghService;

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
        maps.put("sfdj", sfdj);//独居老人
        maps.put("sfkc", sfkc);//是否空巢老人
        maps.put("sfxmsf", sfxmsf);//是否刑满释放
        maps.put("sftyjr", sftyjr);//是否刑满释放
        maps.put("sfdb", sfdb);//是否低保
        maps.put("sfcj", sfcj);//是否残疾人
        maps.put("zdry", zdry);

        startPage();
        List<Map<String, Object>> list = zhsqZhzlService.getZdRyList(maps);
        List<Map<String, Object>> zdList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> zdryjm = list.get(i);
            List<Map<String, Object>> rwghList = zhsqJmrwghService.findAllByJmid((String) zdryjm.get("jmid"));
            zdryjm.put("rwgh", rwghList);
            zdList.add(zdryjm);
        }
        TableDataInfo tableDataInfo = getDataTable(zdList);
        MyTableDataInfo myTableDataInfo = new MyTableDataInfo(tableDataInfo);
        myTableDataInfo.setTotals(zhsqZhzlService.getZdRyCount(maps));
        return myTableDataInfo;
        // return AjaxResult.success(zhsqZhzlService.getZdRyList(maps));
    }

    /**
     * 重点人员列表
     *
     * @return
     */
    @GetMapping("/api/getZdRyRwgh")
    @ResponseBody
    public MyTableDataInfo getZdRyRwgh(@Param("jmid") String jmid,String peersonnel, Integer page, Integer size) {
        List<Map<String, Object>> rwghList = zhsqJmrwghService.findRwghByJmid(page, size,jmid,peersonnel);
        TableDataInfo tableDataInfo = getDataTable(rwghList);
        MyTableDataInfo myTableDataInfo = new MyTableDataInfo(tableDataInfo);
        myTableDataInfo.setTotals(zhsqJmrwghService.getRwghCount(jmid,peersonnel));
        return myTableDataInfo;

    }

    @ApiOperation("添加人文关怀")
    @RequestMapping(value = "/api/addRwgh", method = RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams(
            @ApiImplicitParam(dataType = "ZhsqJmrwgh", name = "zhsqJmrwgh")
    )
    public AjaxResult addYgrz(@RequestBody ZhsqJmrwgh zhsqJmrwgh) {
        return toAjax(zhsqJmrwghService.insertZhsqJmrwgh(zhsqJmrwgh), zhsqJmrwgh);
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
        ZhsqSh zhsqSh = new ZhsqSh();
        zhsqSh.setJmid(jmid);
        List<ZhsqSh> ls = zhsqShService.selectZhsqShList(zhsqSh);
        maps.put("flag", false);
        if (ls != null && ls.size() > 0) {
            maps.put("flag", true);
            String shid = ls.get(0).getShid();
            ZhsqShrz zhsqShrz = new ZhsqShrz();
            zhsqShrz.setShid(shid);
            List<ZhsqShrz> shrzlist = zhsqShrzService.selectZhsqShrzList(zhsqShrz);
            if (shrzlist != null && shrzlist.size() > 0) {
                maps.put("shxx", shrzlist.get(0));
                //添加手环报警信息进入
                String alarmConent = sysDictDataService.selectDictLabel("zhsq_shjg", shrzlist.get(0).getAlarmState());
                if (alarmConent == null) {
                    alarmConent = "";
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
    public AjaxResult getZdsjList(@Param("page") Integer page, @Param("page") Integer size, @Param("xqid") String xqid, @Param("sqid") String sqid, @Param("czzt") String czzt,
                                  @Param("sjlx") String sjlx) throws SQLException {
        Map<String, Object> maps = new HashMap<>();
        maps.put("page", page);
        maps.put("size", size);
        maps.put("xqid", xqid);
        maps.put("sqid", sqid);
        maps.put("czzt", czzt);
        maps.put("sjlx", sjlx);
        List<Map<String, Object>> ycList = zhsqZhzlService.getZdsjList(maps);
        System.out.printf(ycList.toString());
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> resultMap = new HashMap<>();
        Integer ii = zhsqZhzlService.getZdsjCount(maps);
        resultMap.put("total", zhsqZhzlService.getZdsjCount(maps));
        for (int i = 0; i < ycList.size(); i++) {
            Map<String, Object> map = ycList.get(i);
            Object ycxw = map.get("YCNR");
            if (ycxw instanceof ClobProxyImpl) {
                ycxw = ((ClobProxyImpl) ycxw).getSubString(1, (int) ((ClobProxyImpl) ycxw).length());
            }
            Map<String, Object> map1 = new HashMap<>();
            if (map.get("GJSJID") != null) {
                ZhsqSxtrlbkgj zhsqSxtrlbkgj = zhsqSxtrlbkgjService.selectZhsqSxtrlbkgjById((String) map.get("GJSJID"));
                if (zhsqSxtrlbkgj != null) {
                    map1.put("LONGITUDE", zhsqSxtrlbkgj.getLongitude());
                    map1.put("LATITUDE", zhsqSxtrlbkgj.getLatitude());
                    map1.put("SNAPTIME", zhsqSxtrlbkgj.getSnapTime());//人脸抓拍时间
                    map1.put("ALARMTIME", zhsqSxtrlbkgj.getAlarmTime());//报警时间
                    map1.put("ALARMTYPE", zhsqSxtrlbkgj.getAlarmType());//报警类型1：黑名单告警2：白名单告警（即未匹配上的陌生人告警）3：为白名单命中告警（即白名单）
                    map1.put("SNAPFACEPICURL", zhsqSxtrlbkgj.getSnapfacePicurl());//人脸抓拍小图片url
                    map1.put("FACEPICURL", zhsqSxtrlbkgj.getFacePicurl());//名单库人脸url
                    map1.put("SNAPPICURL", zhsqSxtrlbkgj.getSnapPicurl());//人脸抓拍图片url
                    map1.put("FACESAMEVALUE", zhsqSxtrlbkgj.getFaceSamevalue());//人脸相似度
                }
            }
            if (map.get("EVENT_TYPE") != null) {
                ZhsqYcType zhsqYcType = zhsqYcService.selectZhsqYcTypeById((String) map.get("EVENT_TYPE"));
                if (zhsqYcType != null) {
                    map1.put("EVENT_TYPE", zhsqYcType.getName());
                }
            }
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
