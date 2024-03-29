package com.feather.community.controller;

import java.util.List;

import com.feather.system.domain.SysNotice;
import io.swagger.v3.oas.annotations.Parameter;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feather.common.annotation.ClearPage;
import com.feather.common.annotation.Log;
import com.feather.common.core.controller.BaseController;
import com.feather.common.core.domain.AjaxResult;
import com.feather.common.core.page.TableDataInfo;
import com.feather.common.enums.BusinessType;
import com.feather.common.utils.poi.ExcelUtil;
import com.feather.community.domain.ZhsqYc;
import com.feather.community.service.IZhsqYcService;

/**
 * 异常信息Controller
 *
 * @author fancy
 * @date 2020-05-14
 */
@Controller
@RequestMapping("/community/YC")
public class ZhsqYcController extends BaseController {
    private String prefix = "community/YC";

    @Autowired
    private IZhsqYcService zhsqYcService;

    @RequiresPermissions("community:YC:view")
    @GetMapping()
    public String YC() {
        return prefix + "/YC";
    }

    /**
     * 查询异常信息列表
     */
    @RequiresPermissions("community:YC:list")
    @PostMapping("/list")
    @ClearPage
    @ResponseBody
    public TableDataInfo list(ZhsqYc zhsqYc) {
        startPage();
        List<ZhsqYc> list = zhsqYcService.selectZhsqYcList(zhsqYc);
        return getDataTable(list);
    }

    /**
     * 导出异常信息列表
     */
    @RequiresPermissions("community:YC:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ZhsqYc zhsqYc) {
        List<ZhsqYc> list = zhsqYcService.selectZhsqYcList(zhsqYc);
        ExcelUtil<ZhsqYc> util = new ExcelUtil<ZhsqYc>(ZhsqYc.class);
        return util.exportExcel(list, "YC");
    }

    /**
     * 新增异常信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        ZhsqYc YC = new ZhsqYc();
        mmap.put("YC", YC);
        return prefix + "/edit";
    }

    /**
     * 新增保存异常信息
     */
    @RequiresPermissions("community:YC:add")
    @Log(title = "异常信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ZhsqYc zhsqYc) {
        return toAjax(zhsqYcService.insertZhsqYc(zhsqYc));
    }

    /**
     * 修改异常信息
     */
    @GetMapping("/edit/{ycid}")
    public String edit(@PathVariable("ycid") String ycid, ModelMap mmap) {
        ZhsqYc YC = zhsqYcService.selectZhsqYcById(ycid);
        mmap.put("YC", YC);
        return prefix + "/edit";
    }

    /**
     * 修改保存异常信息
     */
    @RequiresPermissions("community:YC:edit")
    @Log(title = "异常信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ZhsqYc zhsqYc) {
        return toAjax(zhsqYcService.updateZhsqYc(zhsqYc));
    }

    /**
     * 删除异常信息
     */
    @RequiresPermissions("community:YC:remove")
    @Log(title = "异常信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(zhsqYcService.deleteZhsqYcByIds(ids));
    }

    /**
     * 前端页面：通知公告更新状态接口
     * 1:通知。 2:公告
     */
    @RequestMapping("/api/updateYc")
    @ResponseBody
    public AjaxResult updateYc(@Parameter String id) {
        ZhsqYc yc = zhsqYcService.selectZhsqYcById(id);
        yc.setNoticeRead("1");
        if (yc.getSbid()!=null&&yc.getEventType()!=null){
            zhsqYcService.updateZhsqYcBySbid(yc);
        }
        return toAjax(zhsqYcService.updateZhsqYc(yc));
    }

    /**
     * 异常派遣处置人和处置时间
     */
    @RequestMapping("/api/updateYcpq")
    @ResponseBody
    public AjaxResult updateYcpq(@Parameter String id, @Parameter String czry, @Parameter String zwczsj) {
        ZhsqYc yc = zhsqYcService.selectZhsqYcById(id);
        yc.setCzry(czry);
        yc.setZwczsj(zwczsj);
        yc.setCzzt("处置中");
        return toAjax(zhsqYcService.updateZhsqYc(yc));
    }

    /**
     * 处置时间和处置结果
     */
    @RequestMapping("/api/updateYccz")
    @ResponseBody
    public AjaxResult updateYccz(@Parameter String id, @Parameter String czjg, @Parameter String czsj) {
        ZhsqYc yc = zhsqYcService.selectZhsqYcById(id);
        yc.setCzjg(czjg);
        yc.setCzsj(czsj);
        yc.setCzzt("已处置");
        return toAjax(zhsqYcService.updateZhsqYc(yc));
    }
}
