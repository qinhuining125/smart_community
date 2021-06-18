package com.feather.community.util;



import com.feather.community.mapper.ZhsqSbrzMapper;

import java.util.List;
import java.util.Map;
import java.util.TimerTask;
/**
 * 执行内容
 * @author admin_Hzw
 *
 */
public class Task extends TimerTask {
    private ZhsqSbrzMapper zhsqSbrzMapper;
    public void run() {
        System.out.printf("sssssssssssssss");
//        List<Map<String, Object>> lastzhsqJgDistance=zhsqSbrzMapper.selectZhsqSbrzNew();
//        System.out.printf(String.valueOf(lastzhsqJgDistance));
    }
}