package com.feather.system.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.feather.common.core.domain.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通知公告表 sys_notice
 * 
 * @author feather
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysNotice extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 公告ID */
    private Long noticeId;

    /** 公告标题 */
    @NotBlank(message = "公告标题不能为空")
    @Size(min = 0, max = 50, message = "公告标题不能超过50个字符")
    private String noticeTitle;

    /** 公告类型（1通知 2公告） */
    private String noticeType;

    /** 公告内容 */
    private String noticeContent;

    /** 公告是否已读,默认为0 */
    private String noticeRead="0";
}
