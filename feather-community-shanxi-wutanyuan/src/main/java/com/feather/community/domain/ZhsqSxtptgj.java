package com.feather.community.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.feather.common.annotation.Excel;
import com.feather.common.core.domain.BaseEntity;
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
public class ZhsqSxtptgj
{
    private static final long serialVersionUID = 1L;

    /** 摄像头报警记录ID */
    @Excel(name = "摄像头报警记录ID")
    private String sxtptgjid;
    /** 告警类型 */
    @Excel(name = "告警类型")
    @JsonProperty("EventType")
    private String EventType;
    /** 设备编码 */
    @Excel(name = "设备编码")
    @JsonProperty("DeviceCode")
    private String DeviceCode;
    /** 设备名称 */
    @Excel(name = "设备名称")
    @JsonProperty("DeviceName")
    private String DeviceName;
    /** 父设备名称 */
    @Excel(name = "父设备名称")
    @JsonProperty("ParentDevName")
    private String ParentDevName;
    /** 告警名称 */
    @Excel(name = "告警名称")
    @JsonProperty("ActiveName")
    private String ActiveName;
    /** 告警级别， 0：危急；1：主要；2：次要；3：警告；4：提示 */
    @Excel(name = "告警级别， 0：危急；1：主要；2：次要；3：警告；4：提示 ")
    @JsonProperty("EventSecurity")
    private int EventSecurity;
    /** 告警触发时间, 时间格式为"YYYY-MM-DD hh:mm:ss" */
    @Excel(name = "告警触发时间")
    @JsonProperty("EventTime")
    private String EventTime;
    /** "告警状态， 0：未确认；1：已确认；2：未核警；3:已核警 */
    @Excel(name = "告警状态， 0：未确认；1：已确认；2：未核警；3:已核警 ")
    @JsonProperty("AlarmStatus")
    private int AlarmStatus;
    /** 事件级别名称 */
    @Excel(name = "事件级别名称")
    @JsonProperty("SecurityName")
    private String SecurityName;
    /** 事件级别显示颜色 */
    @Excel(name = "事件级别显示颜色")
    @JsonProperty("SecurityColor")
    private String SecurityColor;
    /** 告警确认时间, 时间格式为"YYYY-MM-DD hh:mm:ss" */
    @Excel(name = "事件级别显示颜色")
    @JsonProperty("AckTime")
    private String AckTime;
    /** 告警确认用户 */
    @Excel(name = "告警确认用户")
    @JsonProperty("AckUser")
    private String AckUser;
    /** 参数名值对 */
    @Excel(name = "参数名值对")
    @JsonProperty("KeyValue")
    private String KeyValue;
    /** 告警描述信息 */
    @Excel(name = "告警描述信息")
    @JsonProperty("EventDesc")
    private String EventDesc;
    /** 告警确认描述 */
    @Excel(name = "告警确认描述")
    @JsonProperty("AckSuggestion")
    private String AckSuggestion;
}

