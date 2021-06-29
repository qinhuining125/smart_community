package com.feather.community.controller;

import com.alibaba.druid.proxy.jdbc.ClobProxyImpl;
import com.feather.common.core.controller.BaseController;
import com.feather.common.core.domain.AjaxResult;
import com.feather.community.mapper.ZhsqJgDistanceMapper;
import com.feather.community.service.IZhsqSbrzService;
import com.feather.community.service.IZhsqZcService;
import com.feather.community.service.IZhsqZnafService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/znaf")
public class ZhsqZnafController extends BaseController {

    @Autowired
    public IZhsqZnafService iZhsqZnafService;
    @Autowired
    public IZhsqZcService iZhsqZcService;
    @Autowired
    private ZhsqJgDistanceMapper zhsqJgDistanceMapper;

    @Autowired
    private IZhsqSbrzService zhsqSbrzService;

    @RequestMapping("/api/getCountSb")
    @ResponseBody
    public AjaxResult getCountSb(String sqid, String xqid) {
        if (sqid == null && xqid == null) {
            sqid = "SQ000001";
        }
        return AjaxResult.success(iZhsqZnafService.getCountSb(sqid, xqid));
    }

    @RequestMapping("/api/getYcList")
    @ResponseBody
    public AjaxResult getYcList(String sqid, String xqid) {
        if (sqid == null && xqid == null) {
            sqid = "SQ000001";
        }
        return AjaxResult.success(iZhsqZnafService.getYcList(sqid, xqid));
    }

    @RequestMapping("/api/getCountMj")
    @ResponseBody
    public AjaxResult getCountMj(String sqid, String xqid) {
        if (sqid == null && xqid == null) {
            sqid = "SQ000001";
        }
        return AjaxResult.success(iZhsqZnafService.getCountMj(sqid, xqid));
    }

    @RequestMapping("/api/getMjjcList")
    @ResponseBody
    public AjaxResult getMjjcList(String sqid, String xqid) {
        if (sqid == null && xqid == null) {
            sqid = "SQ000001";
        }
        return AjaxResult.success(iZhsqZnafService.getMjjcList(sqid, xqid));
    }

    @RequestMapping("/api/getCountZj")
    @ResponseBody
    public AjaxResult getCountZj(String sqid, String xqid) {
        if (sqid == null && xqid == null) {
            sqid = "SQ000001";
        }
        return AjaxResult.success(iZhsqZnafService.getCountZj(sqid, xqid));
    }

    @RequestMapping("/api/getZjjcList")
    @ResponseBody
    public AjaxResult getZjjcList(String sqid, String xqid) {
        if (sqid == null && xqid == null) {
            sqid = "SQ000001";
        }
        return AjaxResult.success(iZhsqZnafService.getZjjcList(sqid, xqid));
    }

    @RequestMapping("/api/getCountDg")
    @ResponseBody
    public AjaxResult getCountDg(String sqid, String xqid) {
        if (sqid == null && xqid == null) {
            sqid = "SQ000001";
        }
        return AjaxResult.success(iZhsqZnafService.getCountDg(sqid, xqid));
    }

    @RequestMapping("/api/getDgjcList")
    @ResponseBody
    public AjaxResult getDgjcList(String sqid, String xqid) {
        if (sqid == null && xqid == null) {
            sqid = "SQ000001";
        }
        return AjaxResult.success(iZhsqZnafService.getDgjcList(sqid, xqid));
    }

    @RequestMapping("/api/getSxtList")
    @ResponseBody
    public AjaxResult getSxtList(String wzlx, String sqid, String xqid) {
        if (sqid == null && xqid == null) {
            sqid = "SQ000001";
        }
        return AjaxResult.success(iZhsqZnafService.getSxtList(wzlx, sqid, xqid));
    }

    @RequestMapping("/api/getSsjk")
    @ResponseBody
    public AjaxResult getSsjk(String sqid, String xqid) {
        List<Map> countDg = iZhsqZnafService.getCountDg(sqid, xqid);
        List<Map> countZj = iZhsqZnafService.getCountZj(sqid, xqid);
        List<Map> list = new ArrayList<>();
        Map map1 = new HashMap();
        Map map2 = new HashMap();
        Map map3 = new HashMap();
        Map map4 = new HashMap();
        map1.put("进入人数", "0");
        map2.put("进入车辆", "0");
        map3.put("外出人数", "0");
        map4.put("外出车辆", "0");
        for (Map map : countDg) {
            String jczt = map.get("jczt").toString();
            String num = map.get("num").toString();
            if ("进入".equals(jczt)) {
                map2.put("进入车辆", num);
            } else {
                map4.put("外出车辆", num);
            }
        }
        for (Map map : countZj) {
            String jczt = map.get("jczt").toString();
            String num = map.get("num").toString();
            if ("进入".equals(jczt)) {
                map1.put("进入人数", num);
            } else {
                map3.put("外出人数", num);
            }
        }

        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
        return AjaxResult.success(list);
    }

    @RequestMapping("/api/getSblxYcCount")
    @ResponseBody
    public AjaxResult getSblxYcCount(String sqid, String xqid) {
        return AjaxResult.success(iZhsqZcService.getSblxYcCount(sqid, xqid));

    }

    @RequestMapping("/api/getListSb")
    @ResponseBody
    public AjaxResult getListSb(String sblx, String sbmc, String zcid, String sqid, String xqid) {
        return AjaxResult.success(iZhsqZcService.getListSb(sblx, sbmc, zcid, sqid, xqid));

    }

    /**
     * 设备统计
     *
     * @return
     */
    @GetMapping("/api/getSbtj")
    @ResponseBody
    public AjaxResult getSbtj(String sqid, String xqid) {
        System.out.println(iZhsqZnafService.getSbtj(sqid, xqid).toString());
        List<Map<String, Object>> list = iZhsqZnafService.getSbtj(sqid, xqid);
        List<Map<String, Object>> resultList = new ArrayList<>();
        Integer total = 0;
        for (int i = 0; i < list.size(); i++) {
            Map map1 = list.get(i);
            int num = Integer.parseInt(String.valueOf(map1.get("NUM")));
            total += num;

        }
        int otherTotal = 0;
        for (int i = 0; i < list.size(); i++) {
            Map map2 = list.get(i);
            if (map2.get("TYPE").equals("烟感") || map2.get("TYPE").equals("闸机") || map2.get("TYPE").equals("车辆道杆") || map2.get("TYPE").equals("摄像头") || map2.get("TYPE").equals("水表")) {
                Map<String, Object> otherMap = new HashMap<>();
                otherMap.put("TYPE", list.get(i).get("TYPE"));
                otherMap.put("NUM", list.get(i).get("NUM"));
                resultList.add(otherMap);
            }
        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("TOTAL", total);
        resultMap.put("data", resultList);
        return AjaxResult.success(resultMap);
    }

    /**
     * 报警统计
     *
     * @return
     */
    @GetMapping("/api/getBjtj")
    @ResponseBody
    public AjaxResult getBjtj(String sqid, String xqid) {
        List<Map<String, Object>> list = iZhsqZnafService.getBjtj(sqid, xqid);
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

    /**
     * 报警处置
     *
     * @return
     */
    @GetMapping("/api/getBjcz")
    @ResponseBody
    public AjaxResult getBjcz(String sqid, String xqid) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("xqid", xqid);
        maps.put("sqid", sqid);
        List<Map<String, Object>> list = iZhsqZnafService.getBjcz(maps);
        Integer total = 0;
        List<Map<String, Object>> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);

            Map map1 = new HashMap();
            String str = map.get("NUM").toString();
            String str2 = String.valueOf(map.get("TYPE"));
            map1.put("value", str);
            map1.put("name", str2);
            list1.add(map1);

            int num = Integer.parseInt(String.valueOf(map.get("NUM")));
            total += num;

        }
        String str = Integer.toString(total);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("TOTAL", str);
        resultMap.put("data", list1);
        return AjaxResult.success(resultMap);
    }

    /**
     * 异常内容
     *
     * @param sqid
     * @param xqid
     * @return
     */
    @GetMapping("/api/getYcnr")
    @ResponseBody
    public AjaxResult getYcnr(String sqid, String xqid) throws SQLException {
        List<Map<String, Object>> ycnr = iZhsqZnafService.getYcnr(sqid, xqid);
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < ycnr.size(); i++) {
            Map<String, Object> map = ycnr.get(i);
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
            list.add(map1);
        }


        return AjaxResult.success(list);
    }

    /**
     * 视频监控
     *
     * @return
     */
    @GetMapping("/api/getSplb")
    @ResponseBody
    public AjaxResult getSplb(Integer page, Integer size,String sbmc) {
        List<Map<String, Object>> splb =  iZhsqZnafService.getSplb(page, size,sbmc);

//        List<Map<String, Object>> ckrk = new ArrayList<>();
//        List<Map<String, Object>> zdqy = new ArrayList<>();
//        for (int i = 0; i < splb.size(); i++) {
//            Map<String, Object> map = splb.get(i);
//            if (map.get("WZLX").equals("出口入口")) {
//                ckrk.add(map);
//            } else {
//                zdqy.add(map);
//            }
//
//        }
        Map<String, Object> resultmap = new HashMap<>();
        resultmap.put("splb", splb);
//        resultmap.put("ZDQY", zdqy);
        resultmap.put("total", iZhsqZnafService.getSplbCount(page, size,sbmc));
        return AjaxResult.success(resultmap);
    }

    /**
     * 人员进出
     *
     * @return
     */
    @GetMapping("/api/getMjjc")
    @ResponseBody
    public AjaxResult getMjjc(Integer page, Integer size, String jczt) {
        System.out.println(jczt);
        List<Map<String, Object>> list = iZhsqZnafService.getMj();
        int wcCount = 0;
        int jrCount = 0;
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            if (map.get("JCZT").equals("外出")) {
                wcCount++;
            } else {
                jrCount++;
            }
        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("JRRS", jrCount);
        resultMap.put("WCRS", wcCount);
        if (page == null && size == null && jczt == null) {
            resultMap.put("rows", iZhsqZnafService.getMj());
        } else {
            resultMap.put("rows", iZhsqZnafService.getMjjc(page, size, jczt));
        }
        resultMap.put("total", iZhsqZnafService.getMjjcCount(jczt));
        return AjaxResult.success(resultMap);
    }

    /**
     * 车辆进出
     *
     * @return
     */
    @GetMapping("/api/getDgjc")
    @ResponseBody
    public AjaxResult getDgjc(Integer page, Integer size, String jczt) {
        System.out.println(jczt);
        List<Map<String, Object>> list = iZhsqZnafService.getDg();
        int wcCount = 0;
        int jrCount = 0;
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            if (map.get("JCZT").equals("外出")) {
                wcCount++;
            } else {
                jrCount++;
            }
        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("JRRS", jrCount);
        resultMap.put("WCRS", wcCount);
        if (page == null || size == null || jczt == null) {
            resultMap.put("rows", iZhsqZnafService.getDg());
        } else {
            resultMap.put("rows", iZhsqZnafService.getDgjc(page, size, jczt));
        }
        resultMap.put("total", iZhsqZnafService.getDgjcCount(jczt));
        return AjaxResult.success(resultMap);
    }

    /**
     * 烟感展示
     *
     * @return
     */
    @GetMapping("/api/getYgzs")
    @ResponseBody
    public AjaxResult getYgzs(Integer page, Integer size,String sbmc) {
        Map<String, Object> resultMap = new HashMap<>();
        if (page == null || size == null) {
            resultMap.put("rows", iZhsqZnafService.getYg());
        } else {
            resultMap.put("rows", iZhsqZnafService.getYgzs(page, size,sbmc));
        }
        resultMap.put("total", iZhsqZnafService.getYgzsCount(page, size,sbmc));
        return AjaxResult.success(resultMap);
    }


    /**
     * 井盖展示
     *
     * @return
     */
    @GetMapping("/api/getJgzs")
    @ResponseBody
    public AjaxResult getJgzs(Integer page, Integer size,String sbmc,String start, String end) {
        Map<String, Object> resultMap = new HashMap<>();
        if (page == null || size == null) {
            resultMap.put("rows", iZhsqZnafService.getJg());
        } else {
            List<Map<String, Object>> jginfoList=iZhsqZnafService.getJgzs(page, size,sbmc);
            List<Map<String, Object>> rows= new ArrayList<Map<String, Object>>();
            for (int i=0;i<jginfoList.size();i++){
                Map<String, Object> jginfo=jginfoList.get(i);
                List<Map<String, Object>> zhsqJgDistance= zhsqJgDistanceMapper.findBySn((String) jginfo.get("sn"));
                jginfo.put("zhsqJgDistance",zhsqJgDistance);
                jginfo.put("frequency",(int)Math.ceil((double)zhsqJgDistance.size()/2));

                rows.add(jginfo);
            }
            resultMap.put("rows", rows);
//            resultMap.put("rows", iZhsqZnafService.getJgzs(page, size,sbmc));
        }
        resultMap.put("total", iZhsqZnafService.getJgzsCount(page, size,sbmc));
        return AjaxResult.success(resultMap);
    }
    /**
     * 井盖开启记录时间检索
     *
     * @return
     */
    @GetMapping("/api/getjginfo")
    @ResponseBody
    public AjaxResult getjginfo( String sn,String start, String end) {
        List<Map<String, Object>> zhsqJgRZList= zhsqJgDistanceMapper.findJgDisBySSE(sn,start,end);
        return AjaxResult.success(zhsqJgRZList);
    }

    /**
     * 水表展示
     *
     * @return
     */
    @GetMapping("/api/getSbzs")
    @ResponseBody
    public AjaxResult getSbzs(Integer page, Integer size, String sbmc) {
        Map<String, Object> resultMap = new HashMap<>();
        if (page == null || size == null) {
            resultMap.put("rows", iZhsqZnafService.getSb());
        } else {
            List<Map<String, Object>> sbList=iZhsqZnafService.getSbzs(page, size,sbmc);
            List<Map<String, Object>> rows= new ArrayList<Map<String, Object>>();
            for (int i=0;i<sbList.size();i++){
                Map<String, Object> sb=sbList.get(i);
                List<Map<String, Object>> zhsqSBRZ= zhsqSbrzService.selectZhsqSbrzByIdNew((String) sb.get("deviceCode"));
                List<Map<String, Object>> zhsqSBRZList= zhsqSbrzService.selectZhsqSbrzById1List((String) sb.get("deviceCode"));
                Double lastdata=0.0;
                List<Map<String, Object>> dayFlow= new ArrayList<Map<String, Object>>();
                for (int j=0;j<zhsqSBRZList.size();j++){
                    Map<String, Object> sbrz=zhsqSBRZList.get(j);
                   Object total= sbrz.get("TOTAL");
                    Double current= Double.parseDouble(total.toString());
                    Double flow=current-lastdata;
                    sbrz.put("flow",flow);
                    dayFlow.add(sbrz);
                    lastdata=current;
                }
                sb.put("total",zhsqSBRZ.get(0).get("TOTAL"));
                sb.put("dayFlow",dayFlow);
                rows.add(sb);
            }
            resultMap.put("rows", rows);
        }
        resultMap.put("total", iZhsqZnafService.getSbzsCount(page, size,sbmc));
        return AjaxResult.success(resultMap);
    }
    /**
     * 水表展示
     *
     * @return
     */
    @GetMapping("/api/getSbinfo")
    @ResponseBody
    public AjaxResult getSbinfo( String deviceCode,String start, String end) {
        List<Map<String, Object>> zhsqSBRZList= zhsqSbrzService.selectZhsqSbrzByIdAndSEList(deviceCode,start,end);
        Double lastdata=0.0;
        List<Map<String, Object>> dayFlow= new ArrayList<Map<String, Object>>();
        for (int j=0;j<zhsqSBRZList.size();j++){
            Map<String, Object> sbrz=zhsqSBRZList.get(j);
            Object total= sbrz.get("TOTAL");
            Double current= Double.parseDouble(total.toString());
            Double flow=current-lastdata;
            sbrz.put("flow",flow);
            dayFlow.add(sbrz);
            lastdata=current;
        }
        return AjaxResult.success(dayFlow);
    }
    /**
     * 新闻通知或者公告
     *
     * @param sqid
     * @param xqid
     * @return
     * @throws SQLException
     */
    @GetMapping("/api/getXwgg")
    @ResponseBody
    public AjaxResult getXwgg(String sqid, String xqid) throws SQLException {
        List<Map<String, Object>> list = iZhsqZnafService.getXwgg(sqid, xqid);
        Map<String, Object> resultMap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            Object ycxw = map.get("NR");
            if (ycxw instanceof ClobProxyImpl) {
                ycxw = ((ClobProxyImpl) ycxw).getSubString(1, (int) ((ClobProxyImpl) ycxw).length());
            }
            map.put("NR", ycxw);
            if (map.get("GGLX").equals("通知")) {

                resultMap.put("GG", list);
            } else {
                resultMap.put("TZ", list);
            }
        }

        return AjaxResult.success(resultMap);
    }


}