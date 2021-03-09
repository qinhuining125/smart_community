package com.feather.community.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.feather.common.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 烟感对象 ZHSQ_YG
 *
 * @author fancy
 * @date 2020-12-10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZhsqSxtrlbkgj
{
    private static final long serialVersionUID = 1L;

    /** 人脸报警ID */
    @Excel(name = "人脸报警ID")
    @JsonProperty("Id")
    private String Id;
    /** 人脸抓拍图片ID */
    @Excel(name = "人脸抓拍图片ID")
    @JsonProperty("SnappicId")
    private String SnappicId;
    /** 产生报警的布控id */
    @Excel(name = "产生报警的布控id")
    @JsonProperty("GuardtaskId")
    private String GuardtaskId;
    /** 人脸抓拍机编码 */
    @Excel(name = "人脸抓拍机编码")
    @JsonProperty("FacecamCode")
    private String FacecamCode;
    /** 报警时间（yyyy-MM-dd HH:mm:ss） */
    @Excel(name = "报警时间（yyyy-MM-dd HH:mm:ss）")
    @JsonProperty("AlarmTime")
    private String AlarmTime;
    /**  报警类型1：黑名单告警2：白名单告警（即未匹配上的陌生人告警）3：为白名单命中告警（即白名单） */
    @Excel(name = "报警类型1：黑名单告警2：白名单告警（即未匹配上的陌生人告警）3：为白名单命中告警（即白名单） ")
    @JsonProperty("AlarmType")
    private String AlarmType;
    /** 布控列管原因" */
    @Excel(name = "布控列管原因")
    @JsonProperty("GuardReason")
    private String GuardReason;
    /**布控列管类型 */
    @Excel(name = "布控列管类型 ")
    @JsonProperty("GuardType")
    private int GuardType;
    /** 布控的对比库 */
    @Excel(name = "布控的对比库")
    @JsonProperty("FacelibId")
    private String FacelibId;
    /** 人脸名单编号 10*/
    @Excel(name = "人脸名单编号")
    @JsonProperty("FaceId")
    private String FaceId;
    /** 名单库人脸url */
    @Excel(name = "名单库人脸url")
    @JsonProperty("FacePicurl")
    private String FacePicurl;
    /** 人脸抓拍图片url */
    @Excel(name = "人脸抓拍图片url")
    @JsonProperty("SnapPicurl")
    private String SnapPicurl;
    /** 人脸相似度 */
    @Excel(name = "人脸相似度")
    @JsonProperty("FaceSamevalue")
    private int FaceSamevalue;
    /** 人脸抓拍小图片url */
    @Excel(name = "人脸抓拍小图片url")
    @JsonProperty("SnapfacePicurl")
    private String SnapfacePicurl;
    /** 人脸国籍 */
    @Excel(name = "人脸国籍")
    @JsonProperty("FaceCountry")
    private String FaceCountry;
    /** 人脸省份 */
    @Excel(name = "人脸省份")
    @JsonProperty("FaceProvince")
    private String FaceProvince;
    /** 人脸城市 */
    @Excel(name = "人脸城市")
    @JsonProperty("FaceCity")
    private String FaceCity;
    /**  证件类型0：身份证1：驾驶证2：其他证件号 */
    @Excel(name = " 证件类型0：身份证1：驾驶证2：其他证件号 ")
    @JsonProperty("FaceIdtype")
    private int FaceIdtype;
    /** 证件ID */
    @Excel(name = "证件ID")
    @JsonProperty("FaceCardid")
    private String FaceCardid;
    /**  人脸性别， 0：女1：男98：未知 */
    @Excel(name = " 人脸性别， 0：女1：男98：未知 ")
    @JsonProperty("FaceGender")
    private int FaceGender;
    /** 人脸年龄 20*/
    @Excel(name = "人脸年龄")
    @JsonProperty("FaceAge")
    private int FaceAge;
    /** 人脸名字 */
    @Excel(name = "人脸名字")
    @JsonProperty("FaceName")
    private String FaceName;
    /** 人脸生日(格式如：yyyy-MM-dd) */
    @Excel(name = "人脸生日(格式如：yyyy-MM-dd)")
    @JsonProperty("FaceBirthday")
    private String FaceBirthday;
    /** 人脸抓拍时间（yyyy-MM-dd HH:mm:ss） */
    @Excel(name = "人脸抓拍时间（yyyy-MM-dd HH:mm:ss）")
    @JsonProperty("SnapTime")
    private String SnapTime;
    /** 人脸在图片中位置 */
    @Excel(name = "人脸在图片中位置")
    @JsonProperty("FacePlaction")
    private String FacePlaction;
    /** 经度 */
    @Excel(name = "经度")
    @JsonProperty("Longitude")
    private String Longitude;
    /** 纬度 */
    @Excel(name = "纬度")
    @JsonProperty("Latitude")
    private String Latitude;
    /** 人脸备注信息 */
    @Excel(name = "人脸备注信息")
    @JsonProperty("FaceRemark")
    private String FaceRemark;
    /** 民族 */
    @Excel(name = "民族")
    @JsonProperty("Nation")
    private String Nation;
    /** 相机名称 */
    @Excel(name = "相机名称")
    @JsonProperty("FaceCamName")
    private String FaceCamName;
    /** 报警次数 */
    @Excel(name = "报警次数")
    @JsonProperty("AlarmCount")
    private int AlarmCount;
    /** 布控的对比库名称 */
    @Excel(name = "布控的对比库名称")
    @JsonProperty("FacelibName")
    private String FacelibName;
}

