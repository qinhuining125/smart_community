package com.feather.community.controller;

import java.util.List;

import com.feather.community.domain.ZhsqDg;
import com.feather.community.service.IZhsqDgService;
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
import com.feather.common.enums.BusinessType;
import com.feather.common.core.controller.BaseController;
import com.feather.common.core.domain.AjaxResult;
import com.feather.common.utils.poi.ExcelUtil;
import com.feather.common.core.page.TableDataInfo;

/**
 * 车辆道杆Controller
 * 
 * @author fancy
 * @date 2021-04-06
 */
@Controller
@RequestMapping("/community/dg")
public class ZhsqDgController extends BaseController
{
    private String prefix = "community/dg";

    @Autowired
    private IZhsqDgService zhsqDgService;

    @RequiresPermissions("community:dg:view")
    @GetMapping()
    public String dg()
    {
        return prefix + "/dg";
    }

    /**
     * 查询车辆道杆列表
     */
    @RequiresPermissions("community:dg:list")
    @PostMapping("/list")
    @ClearPage
    @ResponseBody
    public TableDataInfo list(ZhsqDg zhsqDg)
    {
        startPage();
        List<ZhsqDg> list = zhsqDgService.selectZhsqDgList(zhsqDg);
        return getDataTable(list);
    }

    /**
     * 导出车辆道杆列表
     */
    @RequiresPermissions("community:dg:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ZhsqDg zhsqDg)
    {
        List<ZhsqDg> list = zhsqDgService.selectZhsqDgList(zhsqDg);
        ExcelUtil<ZhsqDg> util = new ExcelUtil<ZhsqDg>(ZhsqDg.class);
        return util.exportExcel(list, "dg");
    }

    /**
     * 新增车辆道杆
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        ZhsqDg dg = new ZhsqDg();
        mmap.put("dg", dg);
        return prefix + "/edit";
    }

    /**
     * 新增保存车辆道杆
     */
    @RequiresPermissions("community:dg:add")
    @Log(title = "车辆道杆", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ZhsqDg zhsqDg)
    {
        return toAjax(zhsqDgService.insertZhsqDg(zhsqDg), zhsqDg);
    }

    /**
     * 修改车辆道杆
     */
    @GetMapping("/edit/{dgid}")
    public String edit(@PathVariable("dgid") String dgid, ModelMap mmap)
    {
        ZhsqDg dg = zhsqDgService.selectZhsqDgById(dgid);
        mmap.put("dg", dg);
        return prefix + "/edit";
    }

    /**
     * 修改保存车辆道杆
     */
    @RequiresPermissions("community:dg:edit")
    @Log(title = "车辆道杆", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ZhsqDg zhsqDg)
    {
        return toAjax(zhsqDgService.updateZhsqDg(zhsqDg));
    }

    /**
     * 删除车辆道杆
     */
    @RequiresPermissions("community:dg:remove")
    @Log(title = "车辆道杆", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(zhsqDgService.deleteZhsqDgByIds(ids));
    }
}
