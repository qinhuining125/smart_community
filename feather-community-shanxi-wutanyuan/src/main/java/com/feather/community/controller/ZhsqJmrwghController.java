package com.feather.community.controller;

import java.util.List;

import com.feather.community.domain.ZhsqJm;
import com.feather.community.service.IZhsqJmService;
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
import com.feather.community.domain.ZhsqJmrwgh;
import com.feather.community.service.IZhsqJmrwghService;
import com.feather.common.core.controller.BaseController;
import com.feather.common.core.domain.AjaxResult;
import com.feather.common.utils.poi.ExcelUtil;
import com.feather.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author fancy
 * @date 2021-06-21
 */
@Controller
@RequestMapping("/community/jmrwgh")
public class ZhsqJmrwghController extends BaseController
{
    private String prefix = "community/jmrwgh";

    @Autowired
    private IZhsqJmrwghService zhsqJmrwghService;
    @Autowired
    private IZhsqJmService zhsqJmService;
    @RequiresPermissions("community:jmrwgh:view")
    @GetMapping()
    public String jmrwgh()
    {
        return prefix + "/jmrwgh";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("community:jmrwgh:list")
    @PostMapping("/list")
    @ClearPage
    @ResponseBody
    public TableDataInfo list(ZhsqJmrwgh zhsqJmrwgh)
    {
        startPage();
        List<ZhsqJmrwgh> list = zhsqJmrwghService.selectZhsqJmrwghList(zhsqJmrwgh);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("community:jmrwgh:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ZhsqJmrwgh zhsqJmrwgh)
    {
        List<ZhsqJmrwgh> list = zhsqJmrwghService.selectZhsqJmrwghList(zhsqJmrwgh);
        ExcelUtil<ZhsqJmrwgh> util = new ExcelUtil<ZhsqJmrwgh>(ZhsqJmrwgh.class);
        return util.exportExcel(list, "jmrwgh");
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        ZhsqJmrwgh jmrwgh = new ZhsqJmrwgh();
        mmap.put("jmrwgh", jmrwgh);
        return prefix + "/edit";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("community:jmrwgh:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ZhsqJmrwgh zhsqJmrwgh)
    {
        if (zhsqJmrwgh.getJmid()!=""&&zhsqJmrwgh.getXm()==""){
            ZhsqJm JM = zhsqJmService.selectZhsqJmById(zhsqJmrwgh.getJmid());
            zhsqJmrwgh.setXm(JM.getXm());
        }
        return toAjax(zhsqJmrwghService.insertZhsqJmrwgh(zhsqJmrwgh), zhsqJmrwgh);
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{jmrwghid}")
    public String edit(@PathVariable("jmrwghid") String jmrwghid, ModelMap mmap)
    {
        ZhsqJmrwgh jmrwgh = zhsqJmrwghService.selectZhsqJmrwghById(jmrwghid);
        mmap.put("jmrwgh", jmrwgh);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("community:jmrwgh:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ZhsqJmrwgh zhsqJmrwgh)
    {
        return toAjax(zhsqJmrwghService.updateZhsqJmrwgh(zhsqJmrwgh));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("community:jmrwgh:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(zhsqJmrwghService.deleteZhsqJmrwghByIds(ids));
    }
}
