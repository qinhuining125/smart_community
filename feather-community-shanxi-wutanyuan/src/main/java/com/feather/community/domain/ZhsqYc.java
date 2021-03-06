package com.feather.community.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.feather.common.annotation.Excel;
import com.feather.common.core.domain.BaseEntity;

/**
 * 异常信息对象 ZHSQ_YC
 * 
 * @author fancy
 * @date 2020-05-14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZhsqYc extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 异常ID */
    @Excel(name = "异常ID")
    private String ycid;
    /** 异常级别 */
    @Excel(name = "异常级别")
    private String ycjb;
    /** 异常内容 */
    @Excel(name = "异常内容")
    private String ycnr;
    /** 异常来源 */
    @Excel(name = "异常来源")
    private String ycly;
    /** 异常时间 */
    @Excel(name = "异常时间")
    private String ycsj;
    /** 处置状态 */
    @Excel(name = "处置状态")
    private String czzt;
    /** 处置人员 */
    @Excel(name = "处置人员")
    private String czry;
    /** 处置时间 */
    @Excel(name = "最晚处置时间")
    private String zwczsj;
    /** 处置时间 */
    @Excel(name = "处置时间")
    private String czjg;
    /** 附件 */
    @Excel(name = "附件")
    private String fj;
    /** 经度 */
    @Excel(name = "经度")
    private String x;
    /** 纬度 */
    @Excel(name = "纬度")
    private String y;
    /** 高程 */
    @Excel(name = "高程")
    private String z;
    /** 小区id */
    @Excel(name = "小区id")
    private String xqid;
    /** 设备id */
    @Excel(name = "设备id")
    private String sbid;
    /** 社区id */
    @Excel(name = "社区id")
    private String sqid;
    /** 事件类型 */
    @Excel(name = "事件类型")
    private String sjlx;
    /** 处置时间 */
    @Excel(name = "处置时间")
    private String czsj;
    /** 异常信息是否已读，0：表示未读，默认给0，1表示已读 */
    private String noticeRead;
    /** 告警事件id -->目前只有摄像头人脸布控告警需要 */
    private String gjsjid;
    /** 告警类型-->目前只有摄像头普通告警需要 */
    private String eventType;

}
