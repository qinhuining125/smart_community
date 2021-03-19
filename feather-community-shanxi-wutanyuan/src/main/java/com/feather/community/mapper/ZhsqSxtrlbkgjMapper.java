package com.feather.community.mapper;


import com.feather.community.domain.ZhsqSxtrlbkgj;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 烟感Mapper接口
 *
 * @author fancy
 * @date 2020-12-10
 */
public interface ZhsqSxtrlbkgjMapper
{
    /**
     * 查询人脸布控告警事件
     *
     * @param id 告警事件ID
     * @return 告警事件
     */
    public ZhsqSxtrlbkgj selectZhsqSxtrlbkgjById(String id);
    /**
     * 查询人脸布控告警列表
     *
     * @param zhsqSxtrlbkgj 人脸布控告警
     * @return 烟感集合
     */
    public List<ZhsqSxtrlbkgj> selectZhsqSxtrlbkgjList(ZhsqSxtrlbkgj zhsqSxtrlbkgj);

    /**
     * 新增人脸布控告警事件
     *
     * @param zhsqSxtrlbkgj 人脸布控告警
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
//     * 删除烟感
//     *
//     * @param ygid 烟感ID
//     * @return 结果
//     */
//    public int deleteZhsqYgById(String ygid);
//
//    /**
//     * 批量删除烟感
//     *
//     * @param ygids 需要删除的数据ID
//     * @return 结果
//     */
//    public int deleteZhsqYgByIds(String[] ygids);
//    @Select(" select * from zhsq_yg")
//    List<ZhsqYg> getYgList();
//    @Select(" select count(*) from zhsq_yg")
//    int getYgtcount();
//    @Select(" select count(*) from zhsq_dg")
//    int getDgtcount();
}