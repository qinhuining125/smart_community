package com.feather.community.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.feather.common.annotation.ClearPage;
import com.feather.community.domain.*;
import com.feather.community.pojo.SearchEntity;
import com.feather.community.service.*;
import com.feather.community.util.MyTableDataInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feather.common.core.controller.BaseController;
import com.feather.common.core.domain.AjaxResult;
import com.feather.common.core.page.TableDataInfo;

import io.lettuce.core.dynamic.annotation.Param;

@Controller
@RequestMapping("/screen")
public class ScreenIndexController extends BaseController {

    @Autowired
    IZhsqTsjyService zhsqTsjyService;
    @Autowired
    IZhsqYcService zhsqYcService;
    @Autowired
    IZhsqJmService zhsqJmService;
    @Autowired
    IZhsqGgService zhsqGgService;
    @Autowired
    IZhsqZcService zhsqZcService;
    @Autowired
    IZhsqFwService zhsqFwService;
    @Autowired
    IZhsqCwService zhsqCwService;
    @Autowired
    IZhsqSxtService zhsqSxtService;
    @Autowired
    IScreenIndexService screenIndexServie;
    @Autowired
    private IZhsqSbrzService zhsqSbrzService;
    @Autowired
    private IZhsqDyService zhsqDyService;
    @Autowired
    private IZhsqDzzService zhsqDzzService;
    @Autowired
    private IZhsqSbService zhsqSbService;
    @Autowired
    private IZhsqZjService zhsqZjService;
    @Autowired
    private IZhsqJgService zhsqJgService;
    @Autowired
    private IZhsqShService zhsqShService;
    @Autowired
    private IZhsqYgService zhsqYgService;
    @Autowired
    private IZhsqMjService zhsqMjService;
    @Autowired
    public IZhsqZnafService iZhsqZnafService;
    @GetMapping()
    public String index() {
        return "redirect:/bus/community/index.html";
    }

    @RequestMapping("/api/getPersonInfo")
    @ResponseBody
    public AjaxResult getPersonInfo(@Param("xqid") String xqid, @Param("sqid") String sqid) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("xqid", xqid);
        maps.put("sqid", sqid);
        return AjaxResult.success(zhsqJmService.getPersonInfo(maps));
    }

    @RequestMapping("/api/getSuggestionList")
    @ResponseBody
    public AjaxResult getSuggestionList(String sqid, String xqid) {
        return AjaxResult.success(zhsqTsjyService.getSuggestionList(sqid, xqid));
    }

    @RequestMapping("/api/getSourceCount")
    @ResponseBody
    public AjaxResult getSourceCount(String sqid, String xqid) {
        return AjaxResult.success(zhsqYcService.getSourceCount(sqid, xqid));
    }

    @RequestMapping("/api/getStatusCount")
    @ResponseBody
    public AjaxResult getStatusCount(String sqid, String xqid) {
        return AjaxResult.success(zhsqYcService.getStatusCount(sqid, xqid));
    }

    // 通知公告
    @RequestMapping("/api/getAdviceList")
    @ResponseBody
    public TableDataInfo getAdviceList(String sqid, String xqid) {
        startPage();
        List<ZhsqGg> list = zhsqGgService.getZhsqGgList(sqid, xqid);
        return getDataTable(list);
    }

    // 查询设备
    @RequestMapping("/api/getSbJc")
    @ResponseBody
    public AjaxResult getSbJc(String type, String id) {
        if (type.equals("YC")) {
            ZhsqYc zhsqYc = zhsqYcService.selectZhsqYcById(id);
            return AjaxResult.success(zhsqYc);
        }
        List<Map> map = zhsqZcService.getSbJc(type, id);
        return AjaxResult.success(map);
    }

    // 查询房屋
    @RequestMapping("/api/getRyXx")
    @ResponseBody
    public AjaxResult getJmXx(@Param("ldid") String ldid) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("ldid", ldid);
        Map<String, Object> map = zhsqFwService.getFwXx(maps);
        return AjaxResult.success(map);
    }

    // 查询人员
    @RequestMapping("/api/getFwRy")
    @ResponseBody
    public AjaxResult getFwRy(@Param("fwid") String fwid) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("fwid", fwid);
        List<Map<String, Object>> map = zhsqJmService.getFwRy(maps);
        return AjaxResult.success(map);
    }

    /**
     * 查询重点人员信息
     */
    @RequestMapping("/api/getZdryTjByJm")
    @ResponseBody
    public AjaxResult getZdryTjByJm(@Param("ldid") String ldid) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("ldid", ldid);
        AjaxResult result = zhsqJmService.getZdryTj(maps);
        return result;
    }

    @RequestMapping("/api/getSqgkTj")
    @ResponseBody
    public AjaxResult getSqkgTj(@Param("ldid") String ldid) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("ldid", ldid);
        AjaxResult result = zhsqJmService.getSqgkTj(maps);
        return result;
    }

    /**
     * 查询重点人员楼栋信息
     */
    @RequestMapping("/api/getZdRyLd")
    @ResponseBody
    public AjaxResult getZdRyLd() {
        List<Map<String, Object>> map = zhsqJmService.getZdRyLd();
        return AjaxResult.success(map);
    }

    // 查询设备在线统计
    @RequestMapping("/api/getSbxxCount")
    @ResponseBody
    public AjaxResult getSbxxCount(String sqid, String xqid) {
        return AjaxResult.success(zhsqZcService.getSbxxCount(sqid, xqid));
    }

    // 查询重点人员楼栋信息
    @RequestMapping("/api/getSqCwXx")
    @ResponseBody
    public AjaxResult getSqCwXx(@Param("name") String name, ZhsqCw zhsqCw) {
        if (name != null) {
            zhsqCw.setTccmc(name);
        }
        if (name.equals("七宝社区")) {
            zhsqCw.setSqid(zhsqCw.getXqid());
            zhsqCw.setXqid("");
        }
        Map<String, Object> map = zhsqCwService.getSqCwXx(zhsqCw);
        return AjaxResult.success(map);
    }

    // 查询房屋入住率
    @GetMapping("/api/rzl")
    @ResponseBody
    public AjaxResult queryRzlCount(@Param("xqid") String xqid, @Param("sqid") String sqid) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("xqid", xqid);
        maps.put("sqid", sqid);
        return AjaxResult.success(zhsqFwService.selectRzlCount(maps));
    }

    // 房屋统计
    @GetMapping("/api/tj")
    @ResponseBody
    public AjaxResult queryTjCount(@Param("xqid") String xqid, @Param("sqid") String sqid) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("xqid", xqid);
        maps.put("sqid", sqid);
        return AjaxResult.success(zhsqFwService.selectTjCount(maps));
    }

    @RequestMapping("/api/getSxtTj")
    @ResponseBody
    public AjaxResult getSxtTj() {
        Map<String, Object> maps = new HashMap<>(8);
        AjaxResult result = zhsqSxtService.getSxtTj(maps);
        return result;
    }

    /**
     * 是否常驻人口统计
     */
    @RequestMapping("/api/getSfczTjByJm")
    @ResponseBody
    public AjaxResult getSfczTjByJm() {
        Map<String, Object> maps = new HashMap<>(8);
        AjaxResult result = screenIndexServie.getSfczTj(maps);
        return result;
    }

    /**
     * 获取摄像头分页信息
     *
     * @param zhsqSxt
     * @return
     */
    @RequestMapping("/api/getSxtList")
    @ClearPage
    @ResponseBody
    public TableDataInfo getSxtList(ZhsqSxt zhsqSxt) {
        startPage();
        List<ZhsqSxt> list = zhsqSxtService.selectZhsqSxtList(zhsqSxt);
        return getDataTable(list);
    }

    /**
     * 获取居民详情
     *
     * @param jmid
     * @return
     */
    @RequestMapping("/api/getJmById")
    @ResponseBody
    public AjaxResult getJmById(@Param("jmid") String jmid) {
        return zhsqJmService.getZhsqJmById(jmid);
    }

    @RequestMapping("/api/sqglJmTj")
    @ResponseBody
    public AjaxResult sqglJmTj() {
        Map<String, Object> params = new HashMap<>(8);
        return screenIndexServie.sqglJmTj(params);
    }

    /**
     * 智慧党建统计
     *
     * @return
     */
    @RequestMapping("/api/zhdjTj")
    @ResponseBody
    public AjaxResult zhdjTj() {
        Map<String, Object> params = new HashMap<>(8);
        return screenIndexServie.zhdjTj(params);
    }

    /**
     * 社区管理（设备统计）
     *
     * @return
     */
    @RequestMapping("/api/sqglSbTj")
    @ResponseBody
    public AjaxResult sqglSbTj() {
        return screenIndexServie.sqglSbTj();
    }


    /**
     * 社区管理（房屋统计）
     *
     * @return
     */
    @RequestMapping("/api/sqglFwTj")
    @ResponseBody
    public AjaxResult sqglFwTj() {
        return screenIndexServie.sqglFwTj();
    }

    /**
     * 综合治理重点人员统计
     *
     * @return
     */
    @RequestMapping("/api/zhzlZdryTj")
    @ResponseBody
    public AjaxResult zhzlZdryTj() {
        Map<String, Object> params = new HashMap<>(8);
        params.put("sfdj", "是");
        params.put("sfkc", "是");
        params.put("sfxmsf", "是");
        params.put("sftyjr", "是");
        params.put("sfdb", "是");
        params.put("sfcj", "是");
        return screenIndexServie.zhzlZdryTj(params);
    }

    /**
     * 获取居民列表
     *
     * @param zhsqJm
     * @return
     */
    @RequestMapping("/api/getJmList")
    @ClearPage
    @ResponseBody
    public MyTableDataInfo getJmList(ZhsqJm zhsqJm) {
        startPage();
        List<ZhsqJm> list = zhsqJmService.selectZhsqJmList(zhsqJm);
        TableDataInfo tableDataInfo = getDataTable(list);
        MyTableDataInfo myTableDataInfo = new MyTableDataInfo(tableDataInfo);
        return myTableDataInfo;
    }

    /**
     * 获取房屋列表
     *
     * @param zhsqFw
     * @return
     */
    @RequestMapping("/api/getFwList")
    @ClearPage
    @ResponseBody
    public MyTableDataInfo getFwList(ZhsqFw zhsqFw) {
        startPage();
        List<ZhsqFw> list = zhsqFwService.selectZhsqFwList(zhsqFw);
        TableDataInfo tableDataInfo = getDataTable(list);
        MyTableDataInfo myTableDataInfo = new MyTableDataInfo(tableDataInfo);
        return myTableDataInfo;
    }

    @RequestMapping("/api/searchJmList")
    @ClearPage
    @ResponseBody
    public MyTableDataInfo searchJmList(SearchEntity searchEntity) {
        startPage();
        TableDataInfo tableDataInfo = screenIndexServie.searZhsqListByType(searchEntity);
        MyTableDataInfo myTableDataInfo = new MyTableDataInfo(tableDataInfo);
        return myTableDataInfo;
    }

    /**
     * 首页查询汇总，type=3表示为对居民信息的查询，数据库现在数据一共为：652条
     * 1.3号楼假居民数据为66条。
     * 2.'JM000646','JM000647'有两条数据为流动人员，测试数据，假造的3号楼的数据。
     */
    @RequestMapping("/api/searZhsqListByType")
    @ClearPage
    @ResponseBody
    public MyTableDataInfo searZhsqListByType(SearchEntity searchEntity) {
        startPage();
        TableDataInfo tableDataInfo = screenIndexServie.searZhsqListByType(searchEntity);
        MyTableDataInfo myTableDataInfo = new MyTableDataInfo(tableDataInfo);
        return myTableDataInfo;
    }

    @RequestMapping("/api/searchLdList")
    @ClearPage
    @ResponseBody
    public MyTableDataInfo searchLdList(ZhsqLd zhsqLd) {
        startPage();
        TableDataInfo tableDataInfo = screenIndexServie.searchLdList(zhsqLd);
        MyTableDataInfo myTableDataInfo = new MyTableDataInfo(tableDataInfo);
        return myTableDataInfo;
    }

    /**
     * 水量统计接口
     */
    @GetMapping("/api/get5DayData")
    @ClearPage
    @ResponseBody
    public AjaxResult get5DayData() {
        List<Map<String, String>> list = zhsqSbrzService.get5DayData();
        return AjaxResult.success(list);
    }

    /**
     * 党员总数
     */
    @GetMapping("/api/getDySun")
    @ClearPage
    @ResponseBody
    public Integer getDySun() {
        Integer sum = zhsqDyService.getDySun();

        return sum;
    }

    /**
     * 党组织总数
     */
    @GetMapping("/api/getDzzSun")
    @ClearPage
    @ResponseBody
    public Integer getDzzSun() {
        Integer sum = zhsqDzzService.getDzzSun();
        return sum;
    }

    /**
     * 设备列表（水表）
     */
    @GetMapping("/api/getSbList")
    @ClearPage
    @ResponseBody
    public AjaxResult getSbList() {
        List<ZhsqSb> list = zhsqSbService.getSbList();
        return AjaxResult.success(list);
    }
    /**
     * 设备列表（道杆）
     */
    @GetMapping("/api/getDgList")
    @ClearPage
    @ResponseBody
    public AjaxResult getDgList() {
        List<ZhsqDg> list = zhsqSbService.getDgList();
        return AjaxResult.success(list);
    }
    /**
     * 设备列表（摄像头）
     */
    @GetMapping("/api/getSxtList")
    @ClearPage
    @ResponseBody
    public AjaxResult getSxtList() {
        List<ZhsqSxt> list = zhsqSxtService.getSxtList();
        return AjaxResult.success(list);

    }

    /**
     * 设备列表（闸机）
     */
    @GetMapping("/api/getZjList")
    @ClearPage
    @ResponseBody
    public AjaxResult getZjList() {
        List<ZhsqZj> list = zhsqZjService.getZjList();
        return AjaxResult.success(list);
//        return List;
    }

    /**
     * 设备列表（井盖）
     */
    @GetMapping("/api/getJgList")
    @ClearPage
    @ResponseBody
    public AjaxResult getJgList() {
        List<ZhsqJg> list = zhsqJgService.getJgList();
        return AjaxResult.success(list);
    }

    /**
     * 设备列表（手环）
     */
    @GetMapping("/api/getShList")
    @ClearPage
    @ResponseBody
    public AjaxResult getShList() {
        List<ZhsqSh> list = zhsqShService.getShList();
        return AjaxResult.success(list);
    }

    /**
     * 设备列表（烟感）
     */
    @GetMapping("/api/getYgList")
    @ClearPage
    @ResponseBody
    public AjaxResult getYgList() {
        List<ZhsqYg> list = zhsqYgService.getYgList();
        return AjaxResult.success(list);
    }

    /**
     * 设备列表（门禁）
     */
    @GetMapping("/api/getMjList")
    @ClearPage
    @ResponseBody
    public AjaxResult getMjList() {
        List<ZhsqMj> list = zhsqMjService.getMjList();
        return AjaxResult.success(list);
    }

    //智能安防
    //设备统计

    /**
     * 设备（统计）
     */
    @GetMapping("/api/getSbtjcount")
    @ResponseBody
    public AjaxResult getSbtjcount() {
        int sxtCount = zhsqSxtService.getSxtcount();
        int zjCount = zhsqZjService.getZjtcount();
        int ygCount = zhsqYgService.getYgtcount();
        int dgCount = zhsqYgService.getDgtcount();
        int sbtjCount = sxtCount + zjCount + ygCount + dgCount;

        List<Map<String, Object>> resultList = new ArrayList<>();

        Map<String, Object> sxtMap = new HashMap<>();
        sxtMap.put("TYPE",  "摄像头");
        sxtMap.put("NUM", sxtCount);
        resultList.add(sxtMap);
        Map<String, Object> zjMap = new HashMap<>();
        zjMap.put("TYPE", "闸机");
        zjMap.put("NUM", zjCount);
        resultList.add(zjMap);
        Map<String, Object> ygMap = new HashMap<>();
        ygMap.put("TYPE", "烟感");
        ygMap.put("NUM", ygCount);
        resultList.add(ygMap);
        Map<String, Object> dgMap = new HashMap<>();
        dgMap.put("TYPE", "车辆道杆");
        dgMap.put("NUM", dgCount);
        resultList.add(dgMap);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("TOTAL", sbtjCount);
        resultMap.put("data", resultList);
        return AjaxResult.success(resultMap);
    }
    /**
     * 报警事件
     */
    @GetMapping("/api/getBjtj")
    @ClearPage
    @ResponseBody
    public AjaxResult getBjtj() {
        List<Map<String, Object>> list = iZhsqZnafService.getBjtj2();
        List<String> color = new ArrayList();
        color.add("#43e8bf");
        color.add("#fde57c");
        color.add("#f38949");
        color.add("#7aedfb");
        color.add("#4bd896");
        color.add("#3aedfb");
        color.add("#5bd896");
        List<Map<String, Object>> resultList = new ArrayList<>();
        double total = 0;
        for (int i = 0; i < list.size(); i++) {
            Map map1 = list.get(i);
            int num = Integer.parseInt(String.valueOf(map1.get("NUM")));
            total += num;
        }
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map2 = list.get(i);
            int num = Integer.parseInt(String.valueOf(map2.get("NUM")));
            double zb = (num / total) * 100;
            int bfzb = new Double(zb).intValue();
//            String bfzb = String.valueOf(zb2);
            Map<String, Object> map3 = new HashMap<>();
            map3.put("name", map2.get("TYPE"));
            map3.put("value", map2.get("NUM"));
            map3.put("percentage", bfzb);
            map3.put("color", color.get(i));
            resultList.add(map3);
            System.out.println(resultList.toString());
        }
        return AjaxResult.success(resultList);
    }


}
