package com.feather.community.service;


import com.feather.community.domain.ZhsqSxtrlbkgj;
import com.feather.community.domain.ZhsqYg;

import java.util.List;

/**
 * 烟感Service接口
 *
 * @author fancy
 * @date 2020-12-10
 */
public interface IZhsqSxtrlbkgjService
{
    /**
     * 查询人脸布控
     *
     * @param gjsjid 告警事件ID
     * @return 烟感
     */
    public ZhsqSxtrlbkgj selectZhsqSxtrlbkgjById(String gjsjid);

    /**
     * 查询人脸布控事件列表
     *
     * @param zhsqSxtrlbkgj 烟感
     * @return 烟感集合
     */
    public List<ZhsqSxtrlbkgj> selectZhsqSxtrlbkgjList(ZhsqSxtrlbkgj zhsqSxtrlbkgj);

    /**
     * 新增烟感
     *
     * @param zhsqSxtrlbkgj 烟感
     * @return 结果
     */
    public int insertZhsqSxtrlbkgj(ZhsqSxtrlbkgj zhsqSxtrlbkgj);

//    /**
//     * 修改烟感
//     *
//     * @param zhsqYg 烟感
//     * @return 结果
//     */
//    public int updateZhsqYg(ZhsqYg zhsqYg);
//
//    /**
//     * 批量删除烟感
//     *
//     * @param ids 需要删除的数据ID
//     * @return 结果
//     */
//    public int deleteZhsqYgByIds(String ids);
//
//    /**
//     * 删除烟感信息
//     *
//     * @param ygid 烟感ID
//     * @return 结果
//     */
//    public int deleteZhsqYgById(String ygid);
//
//    List<ZhsqYg> getYgList();
//
//    int getYgtcount();
//
//    int getDgtcount();
}