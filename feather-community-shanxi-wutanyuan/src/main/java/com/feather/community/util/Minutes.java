package com.feather.community.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Minutes {
    public static long min(String createTime)throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");//注意月份是MM
        Date createTime1 = simpleDateFormat.parse(createTime);
        Date currentDate = new Date();

        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = currentDate.getTime() - createTime1.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        long Minutes = day * 60 * 24 + hour * 60 + min;
        return Minutes;
    }

}
