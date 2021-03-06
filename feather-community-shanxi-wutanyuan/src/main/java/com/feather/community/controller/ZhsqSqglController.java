package com.feather.community.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feather.common.core.controller.BaseController;
import com.feather.common.core.domain.AjaxResult;
import com.feather.community.service.IZhsqSqglService;
import com.feather.community.service.IZhsqZcService;

import io.lettuce.core.dynamic.annotation.Param;

@Controller
@RequestMapping("/sqgl")
public class ZhsqSqglController extends BaseController {

    @Autowired
    public IZhsqSqglService iZhsqSqglService;
    @Autowired
    public IZhsqZcService iZhsqZcService;

    @RequestMapping("/api/getCountGk")
    @ResponseBody
    public AjaxResult getCountGk(String sqid, String xqid) {
        return AjaxResult.success(iZhsqSqglService.getCountGk(sqid, xqid));
    }

    @RequestMapping("/api/getCountJc")
    @ResponseBody
    public AjaxResult getCountJc(String sqid, String xqid) {
        List<Map> countCl = iZhsqSqglService.getCountCl(sqid, xqid);
        List<Map> countLx = iZhsqSqglService.getCountLx(sqid, xqid);
       /* List<Map> countjc = iZhsqSqglService.getCountJc(sqid, xqid);*/
        Map map = new HashMap();
        //循环listmap然后重新放入数值
        List<Map>  lms=new ArrayList<>();
        Map maps1=new HashMap();
        maps1.put("name", "外来车辆");
        maps1.put("enterNumber",0);
        maps1.put("outerNumber",0);
        Map maps2=new HashMap();
        maps2.put("name", "小区车辆");
        maps2.put("enterNumber",0);
        maps2.put("outerNumber",0);

        for( int i = 0; i < countLx.size(); i++ ) {
            if(countLx.get(i).get("CLLX").equals("外来车辆")){
                if(countLx.get(i).get("JCZT").equals("进入")){
                    maps1.put("enterNumber", countLx.get(i).get("NUM"));
                }
                if(countLx.get(i).get("JCZT").equals("外出")){
                    maps1.put("outerNumber", countLx.get(i).get("NUM"));
                }
            }
            if(countLx.get(i).get("CLLX").equals("小区车辆")){
                if(countLx.get(i).get("JCZT").equals("进入")){
                    maps2.put("enterNumber", countLx.get(i).get("NUM"));
                }
                if(countLx.get(i).get("JCZT").equals("外出")){
                    maps2.put("outerNumber", countLx.get(i).get("NUM"));
                }
            }
        }
        lms.add(maps1);
        lms.add(maps2);
        List<Map>  cls=new ArrayList<>();
        Map maps5=new HashMap();
        maps5.put("name", "车辆总数");
        maps5.put("value",countCl.get(0).get("VALUE"));
        cls.add(maps5);

        map.put("carLeftList", cls);
        map.put("carNumberState", lms);
        return AjaxResult.success(map);
    }

    @RequestMapping("/api/getCountLx")
    @ResponseBody
    public AjaxResult getCountLx(String sqid, String xqid) {
        return AjaxResult.success(iZhsqSqglService.getCountLx(sqid, xqid));
    }

    /**
     * 左侧人员统计
     * 
     * @return
     */
    @GetMapping("/api/selectZcryCount")
    @ResponseBody
    public AjaxResult selectZcryCount(@Param("xqid") String xqid, @Param("sqid") String sqid) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("xqid", xqid);
        maps.put("sqid", sqid);
        return AjaxResult.success(iZhsqSqglService.selectZcryCount(maps));
    }

    /**
     * 年龄结构统计
     * 
     * @return
     */
    @GetMapping("/api/getNlCount")
    @ResponseBody
    public AjaxResult getNlCount(@Param("xqid") String xqid, @Param("sqid") String sqid, @Param("sfcz") String sfcz) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("xqid", xqid);
        maps.put("sqid", sqid);
        maps.put("sfcz", sfcz);
        return AjaxResult.success(iZhsqSqglService.getNlCount(maps));
    }

    /**
     * 男女比例
     * 
     * @return
     */
    @GetMapping("/api/getNnBlCount")
    @ResponseBody
    public AjaxResult getNnBlCount(@Param("xqid") String xqid, @Param("sqid") String sqid, @Param("sfcz") String sfcz) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("xqid", xqid);
        maps.put("sqid", sqid);
        maps.put("sfcz", sfcz);
        return AjaxResult.success(iZhsqSqglService.getNnBlCount(maps));
    }

    /**
     * 民族比例
     * 
     * @return
     */
    @GetMapping("/api/getMzBlCount")
    @ResponseBody
    public AjaxResult getMzBlCount(@Param("xqid") String xqid, @Param("sqid") String sqid, @Param("sfcz") String sfcz) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("xqid", xqid);
        maps.put("sqid", sqid);
        maps.put("sfcz", sfcz);
        return AjaxResult.success(iZhsqSqglService.getMzBlCount(maps));
    }

    /**
     * 人员列表
     * 
     * @return
     */
    @GetMapping("/api/getRyList")
    @ResponseBody
    public AjaxResult getRyList(@Param("xqid") String xqid, @Param("sqid") String sqid, @Param("sfcz") String sfcz,
            @Param("ry") String ry) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("xqid", xqid);
        maps.put("sqid", sqid);
        maps.put("sfcz", sfcz);
        maps.put("ry", ry);
        return AjaxResult.success(iZhsqSqglService.getRyList(maps));
    }

    /**
     * 人员信息
     * 
     * @return
     */
    @GetMapping("/api/getRyInfo")
    @ResponseBody
    public AjaxResult getRyInfo(@Param("jmid") String jmid) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("jmid", jmid);
        return AjaxResult.success(iZhsqSqglService.getRyInfo(maps));
    }

    /**
     * 手环信息
     * 
     * @return
     */
    @GetMapping("/api/getBraceletInfo")
    @ResponseBody
    public AjaxResult getBraceletInfo(@Param("jmid") String jmid) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("jmid", jmid);
        return AjaxResult.success(iZhsqSqglService.getBraceletInfo(maps));
    }

    /**
     * 手环设备电量/计步信息/温度计量信息
     * 
     * @return
     */
    @GetMapping("/api/getBreatHeartInfo")
    @ResponseBody
    public AjaxResult getBreatHeartInfo(@Param("jmid") String jmid) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("jmid", jmid);
        return AjaxResult.success(iZhsqSqglService.getBreatHeartInfo(maps));
    }

    /**
     * 定位信息
     * 
     * @return
     */
    @GetMapping("/api/getLocation")
    @ResponseBody
    public AjaxResult getLocation(@Param("jmid") String jmid) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("jmid", jmid);
        return AjaxResult.success(iZhsqSqglService.getLocationInfo(maps));
    }

    /**
     * 定位信息
     * 
     * @return
     */
    @GetMapping("/api/getWarringInfo")
    @ResponseBody
    public AjaxResult getWarringInfo(@Param("jmid") String jmid) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("jmid", jmid);
        return AjaxResult.success(iZhsqSqglService.getWarringInfo(maps));
    }

    /**
     * 重点事件详情
     * 
     * @return
     */
    @GetMapping("/api/getZdsjInfo")
    @ResponseBody
    public AjaxResult getZdsjInfo(@Param("ycid") String ycid) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("ycid", ycid);
        return AjaxResult.success(iZhsqSqglService.getZdsjInfo(maps));
    }

    /**
     * 巡检任务详情
     * 
     * @return
     */
    @GetMapping("/api/getXjrwInfo")
    @ResponseBody
    public AjaxResult getXjrwInfo(@Param("wyxcid") String wyxcid) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("wyxcid", wyxcid);
        return AjaxResult.success(iZhsqSqglService.getXjrwInfo(maps));
    }

    /**
     * 左侧房屋统计
     * 
     * @return
     */
    @GetMapping("/api/selectZcfwCount")
    @ResponseBody
    public AjaxResult selectZcfwCount(@Param("xqid") String xqid, @Param("sqid") String sqid) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("xqid", xqid);
        maps.put("sqid", sqid);
        return AjaxResult.success(iZhsqSqglService.selectZcfwCount(maps));
    }

    /**
     * 左侧房屋图表统计
     * 
     * @return
     */
    @GetMapping("/api/selectZcfwTbCount")
    @ResponseBody
    public AjaxResult selectZcfwTbCount(@Param("xqid") String xqid, @Param("sqid") String sqid) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("xqid", xqid);
        maps.put("sqid", sqid);
        return AjaxResult.success(iZhsqSqglService.selectZcfwTbCount(maps));
    }

    /**
     * 房屋列表
     * 
     * @return
     */
    @GetMapping("/api/getFwList")
    @ResponseBody
    public AjaxResult getFwList(@Param("xqid") String xqid, @Param("sqid") String sqid, @Param("fwrzqk") String fwrzqk,
            @Param("fwlylx") String fwlylx, @Param("cqzt") String cqzt, @Param("fw") String fw) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("xqid", xqid);
        maps.put("sqid", sqid);
        maps.put("fwrzqk", fwrzqk);
        maps.put("fwlylx", fwlylx);
        maps.put("cqzt", cqzt);
        maps.put("fw", fw);
        return AjaxResult.success(iZhsqSqglService.getFwList(maps));
    }

    /**
     * 楼栋列表
     * 
     * @return
     */
    @GetMapping("/api/getLdList")
    @ResponseBody
    public AjaxResult getLdList(@Param("xqid") String xqid, @Param("sqid") String sqid, @Param("ld") String ld) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("xqid", xqid);
        maps.put("sqid", sqid);
        maps.put("ld", ld);
        return AjaxResult.success(iZhsqSqglService.getLdList(maps));
    }

    /**
     * 房屋信息
     * 
     * @return
     */
    @GetMapping("/api/getFwInfo")
    @ResponseBody
    public AjaxResult getFwInfo(@Param("fwid") String fwid, @Param("ldid") String ldid) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("fwid", fwid);
        maps.put("ldid", ldid);
        return AjaxResult.success(iZhsqSqglService.getFwInfo(maps));
    }

    /**
     * 楼栋弹框信息
     * 
     * @return
     */
    @GetMapping("/api/getLdInfo")
    @ResponseBody
    public AjaxResult getLdInfo(@Param("ldid") String ldid) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("ldid", ldid);
        return AjaxResult.success(iZhsqSqglService.getLdInfo(maps));
    }

    /**
     * 车辆进出信息
     * 
     * @return
     */
    @GetMapping("/api/getCljcList")
    @ResponseBody
    public AjaxResult getCljcList(String sqid, String xqid, String clhm, String id, String cllx) {
        return AjaxResult.success(iZhsqZcService.getCljcList(sqid, xqid, clhm, id, cllx));
    }

    /**
     * 车辆统计信息
     * 
     * @return
     */
    @GetMapping("/api/getClList")
    @ResponseBody
    public AjaxResult getClList(String sqid, String xqid, String clhm, String id, String cx) {
        return AjaxResult.success(iZhsqZcService.getClList(sqid, xqid, clhm, id, cx));
    }

}