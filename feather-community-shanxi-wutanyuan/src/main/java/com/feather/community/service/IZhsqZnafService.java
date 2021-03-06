package com.feather.community.service;

import java.util.List;
import java.util.Map;

/**
 * 社区资产Service接口
 *
 * @author fancy
 * @date 2020-05-14
 */
public interface IZhsqZnafService {
    public List<Map> getCountSb(String sqid, String xqid);

    public List<Map> getYcList(String sqid, String xqid);

    public List<Map> getCountMj(String sqid, String xqid);

    public List<Map> getMjjcList(String sqid, String xqid);

    public List<Map> getCountZj(String sqid, String xqid);

    public List<Map> getZjjcList(String sqid, String xqid);

    public List<Map> getCountDg(String sqid, String xqid);

    public List<Map> getDgjcList(String sqid, String xqid);

    public List<Map> getSxtList(String wzlx, String sqid, String xqid);

    //设备统计
    public List<Map<String, Object>> getSbtj(String sqid, String xqid);

    //报警统计
    public List<Map<String, Object>> getBjtj(String sqid, String xqid);

    //报警处置
    public List<Map<String, Object>> getBjcz(Map<String, Object> maps);

    //异常处理
    public List<Map<String, Object>> getYcnr(String sqid, String xqid);



    //门禁出入
    public List<Map<String, Object>> getMjjc(Integer page, Integer size, String jczt);

    //门禁出入记录总数
    public Integer getMjjcCount(String jczt);


    public List<Map<String, Object>> getMj();

    //道杆车辆
    public List<Map<String, Object>> getDg();
    //道杆车辆出入记录总数
    public List<Map<String, Object>> getDgjc(Integer page, Integer size, String jczt);
    //门禁出入总记录
    public Integer getDgjcCount(String jczt);

    //烟感展示
    public List<Map<String, Object>> getYgzs(Integer page, Integer size,String sbmc);
    //烟感总记录
    public List<Map<String, Object>> getYg();
    //烟感总记录数
    public Integer getYgzsCount(Integer page, Integer size,String sbmc);

    //井盖展示
    public List<Map<String, Object>> getJgzs(Integer page, Integer size,String sbmc);
    //井盖总记录
    public List<Map<String, Object>>  getJg();
    //井盖总记录数
    public Integer getJgzsCount(Integer page, Integer size,String sbmc);



    //水表展示
    public List<Map<String, Object>> getSbzs(Integer page, Integer size,String sbmc);
    //水表总记录
    public List<Map<String, Object>>  getSb();
    //水表盖总记录数
    public Integer getSbzsCount(Integer page, Integer size, String sbmc);

    //新闻公告
    public List<Map<String, Object>>  getXwgg(String sqid, String xqid);

    public List<Map<String, Object>> getBjtj2();
    //视频列表
    public List<Map<String, Object>> getSplb(Integer page, Integer size, String sbmc);
    //视频总数
    public Integer getSplbCount(Integer page, Integer size, String sbmc);
    //火警
    public List<Map<String, Object>> getHJ();
}