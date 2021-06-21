package com.feather.community.controller;

import java.util.List;
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
import com.feather.community.domain.ZhsqJgDistance;
import com.feather.community.service.IZhsqJgDistanceService;
import com.feather.common.core.controller.BaseController;
import com.feather.common.core.domain.AjaxResult;
import com.feather.common.utils.poi.ExcelUtil;
import com.feather.common.core.page.TableDataInfo;

/**
 * 井盖开关记录Controller
 * 
 * @author qhn
 * @date 2021-06-21
 */
@Controller
@RequestMapping("/community/distancerecord")
public class ZhsqJgDistanceController extends BaseController
{
    private String prefix = "community/distancerecord";

    @Autowired
    private IZhsqJgDistanceService zhsqJgDistanceService;

    @RequiresPermissions("community:distancerecord:view")
    @GetMapping()
    public String distancerecord()
    {
        return prefix + "/distancerecord";
    }

    /**
     * 查询井盖开关记录列表
     */
    @RequiresPermissions("community:distancerecord:list")
    @PostMapping("/list")
    @ClearPage
    @ResponseBody
    public TableDataInfo list(ZhsqJgDistance zhsqJgDistance)
    {
        startPage();
        List<ZhsqJgDistance> list = zhsqJgDistanceService.selectZhsqJgDistanceList(zhsqJgDistance);
        return getDataTable(list);
    }

    /**
     * 导出井盖开关记录列表
     */
    @RequiresPermissions("community:distancerecord:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ZhsqJgDistance zhsqJgDistance)
    {
        List<ZhsqJgDistance> list = zhsqJgDistanceService.selectZhsqJgDistanceList(zhsqJgDistance);
        ExcelUtil<ZhsqJgDistance> util = new ExcelUtil<ZhsqJgDistance>(ZhsqJgDistance.class);
        return util.exportExcel(list, "distancerecord");
    }

    /**
     * 新增井盖开关记录
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        ZhsqJgDistance distancerecord = new ZhsqJgDistance();
        mmap.put("distancerecord", distancerecord);
        return prefix + "/edit";
    }

    /**
     * 新增保存井盖开关记录
     */
    @RequiresPermissions("community:distancerecord:add")
    @Log(title = "井盖开关记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ZhsqJgDistance zhsqJgDistance)
    {
        return toAjax(zhsqJgDistanceService.insertZhsqJgDistance(zhsqJgDistance), zhsqJgDistance);
    }

    /**
     * 修改井盖开关记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        ZhsqJgDistance distancerecord = zhsqJgDistanceService.selectZhsqJgDistanceById(id);
        mmap.put("distancerecord", distancerecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存井盖开关记录
     */
    @RequiresPermissions("community:distancerecord:edit")
    @Log(title = "井盖开关记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ZhsqJgDistance zhsqJgDistance)
    {
        return toAjax(zhsqJgDistanceService.updateZhsqJgDistance(zhsqJgDistance));
    }

    /**
     * 删除井盖开关记录
     */
    @RequiresPermissions("community:distancerecord:remove")
    @Log(title = "井盖开关记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(zhsqJgDistanceService.deleteZhsqJgDistanceByIds(ids));
    }
}
