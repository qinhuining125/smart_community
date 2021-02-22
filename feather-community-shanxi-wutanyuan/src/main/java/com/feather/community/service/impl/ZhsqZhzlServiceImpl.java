package com.feather.community.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feather.community.mapper.ZhsqZhzlMapper;
import com.feather.community.service.IZhsqZhzlService;

/**
 * 综合治理
 * 
 * @author fancy
 * @date 2020-05-14
 */
@Service
public class ZhsqZhzlServiceImpl implements IZhsqZhzlService {
    @Autowired
    private ZhsqZhzlMapper zhsqZhzlMapper;

    /**
     * 统计重点人员
     * 
     * @param maps
     * @return
     */
    @Override
    public List<Map<String, Object>> selectZdryCount(Map<String, Object> maps) {

        Map<String, Object> map=zhsqZhzlMapper.selectZdryCount(maps);
        List< Map<String, Object> > ls=new ArrayList<>();
        for (String key : map.keySet()) {
            if(key.equals("XMSF")){
                Map<String, Object> map1=new HashMap<>();
                map1.put("name","刑满释放");
                map1.put("value",map.get(key));
                ls.add(map1);
            }else if(key.equals("CJLR")){
                Map<String, Object> map1=new HashMap<>();
                map1.put("name","残疾人员");
                map1.put("value",map.get(key));
                ls.add(map1);
            }else if(key.equals("MUN")){
                Map<String, Object> map1=new HashMap<>();
                map1.put("name","总人数");
                map1.put("value",map.get(key));
                ls.add(map1);
            }else if(key.equals("DBRY")){
                Map<String, Object> map1=new HashMap<>();
                map1.put("name","低保人员");
                map1.put("value",map.get(key));
                ls.add(map1);
            }else if(key.equals("DJLR")){
                Map<String, Object> map1=new HashMap<>();
                map1.put("name","独居老人");
                map1.put("value",map.get(key));
                ls.add(map1);
            }else if(key.equals("TWJR")){
                Map<String, Object> map1=new HashMap<>();
                map1.put("name","退伍军人");
                map1.put("value",map.get(key));
                ls.add(map1);
            }else{
                Map<String, Object> map1=new HashMap<>();
                map1.put("name","空巢老人");
                map1.put("value",map.get(key));
                ls.add(map1);
            }

        }
        return ls;
    }

    /**
     * 统计重点人员分布情况
     * 
     * @param maps
     * @return
     */
    @Override
    public List<Map<String, Object>> getZdryFb(Map<String, Object> maps) {
        return zhsqZhzlMapper.getZdryFb(maps);
    }

    /**
     * 统计重点人员年龄结构
     * 
     * @param maps
     * @return
     */
    @Override
    public Object[] getZdNl(Map<String, Object> maps) {
        Map<String, Object> zdNl = zhsqZhzlMapper.getZdNl(maps);
        Object[] s = { zdNl.get("A"), zdNl.get("B"), zdNl.get("C"), zdNl.get("D"), zdNl.get("E"), zdNl.get("F") };
        return s;
    }

    /**
     * 统计重点人员男女比例
     * 
     * @param maps
     * @return
     */
    @Override
    public List<Map<String, Object>> getZdNnBl(Map<String, Object> maps) {
        return zhsqZhzlMapper.getZdNnBl(maps);
    }

    /**
     * 统计重点人员民族比例
     * 
     * @param maps
     * @return
     */
    @Override
    public List<Map<String, Object>> getZdMzBl(Map<String, Object> maps) {
        return zhsqZhzlMapper.getZdMzBl(maps);
    }

    /**
     * 重点人员列表
     * 
     * @param maps
     * @return
     */
    @Override
    public List<Map<String, Object>> getZdRyList(Map<String, Object> maps) {
        return zhsqZhzlMapper.getZdRyList(maps);
    }

    /**
     * 巡检任务统计
     * 
     * @param maps
     * @return
     */
    @Override
    public Map<String, Object> selectXjrwCount(Map<String, Object> maps) {
        return zhsqZhzlMapper.selectXjrwCount(maps);
    }

    /**
     * 首页人员巡检
     * 
     * @param maps
     * @return
     */
    @Override
    public List<Map<String, Object>> selectRyxjCount(Map<String, Object> maps) {
        return zhsqZhzlMapper.selectRyxjCount(maps);
    }

    /**
     * 巡检任务
     * 
     * @param maps
     * @return
     */
    @Override
    public List<Map<String, Object>> getXjrw(Map<String, Object> maps) {
        return zhsqZhzlMapper.getXjrw(maps);
    }

    /**
     * 重点事件
     * 
     * @param maps
     * @return
     */
    @Override
    public Map<String, Object> selectZdsjCount(Map<String, Object> maps) {
        Map<String, Object> stringObjectMap = zhsqZhzlMapper.selectZdsjCount(maps);
        Map<String, Object> stringObjectMap1 = zhsqZhzlMapper.selectZdsjFslCount(maps);
        stringObjectMap.putAll(stringObjectMap1);
        return stringObjectMap;
    }

    /**
     * 重点事件扇形图
     * 
     * @param maps
     * @return
     */
    @Override
    public List<Map<String, Object>> selectZdsjTCount(Map<String, Object> maps) {
        return zhsqZhzlMapper.selectZdsjTCount(maps);
    }

    /**
     * 重点事件列表
     * 
     * @param maps
     * @return
     */
    @Override
    public List<Map<String, Object>> getZdsjList(Map<String, Object> maps) {
        return zhsqZhzlMapper.getZdsjList(maps);
    }
}
