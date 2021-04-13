package com.feather.community.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-07 11:23
 * @description 智慧社区_楼栋 ZHSQ_LD
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZhsqYgVo {
    private static final long serialVersionUID = 1L;

    /** 楼栋id */
    private String ldid;

    /** 楼栋名称 */
    private String ldmc;

    /**单元号*/
    private String dyh;

    /**单元id*/
    private String dyid;

    /**房屋列表*/
    private List<ZhsqYg> zhsqYgs;


    private String x;
    private String y;



}
