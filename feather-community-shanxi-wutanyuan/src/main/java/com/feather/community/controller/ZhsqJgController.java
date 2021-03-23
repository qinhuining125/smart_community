package com.feather.community.controller;

import com.feather.common.annotation.ClearPage;
import com.feather.common.annotation.Log;
import com.feather.common.config.Global;
import com.feather.common.core.controller.BaseController;
import com.feather.common.core.domain.AjaxResult;
import com.feather.common.core.page.TableDataInfo;
import com.feather.common.enums.BusinessType;
import com.feather.common.json.JSONObject;
import com.feather.common.utils.poi.ExcelUtil;
import com.feather.community.domain.*;
import com.feather.community.service.IZhsqJgDistanceService;
import com.feather.community.service.IZhsqJgErrorService;
import com.feather.community.service.IZhsqJgService;
import com.feather.community.util.HttpUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 井盖Controller
 * 
 * @author fancy
 * @date 2020-12-11
 */
@Controller
@RequestMapping("/community/JG")
public class ZhsqJgController extends BaseController
{
    private String prefix = "community/JG";
    static ExecutorService fixedThreadPool = Executors.newCachedThreadPool();

    @Autowired
    private IZhsqJgService zhsqJgService;
    @Autowired
    private IZhsqJgDistanceService zhsqJgDistanceService;
    @Autowired
    private IZhsqJgErrorService zhsqJgErrorService;

    @RequiresPermissions("community:JG:view")
    @GetMapping()
    public String JG()
    {
        return prefix + "/JG";
    }

    /**
     * 查询井盖列表
     */
    @RequiresPermissions("community:JG:list")
    @PostMapping("/list")
    @ClearPage
    @ResponseBody
    public TableDataInfo list(ZhsqJg zhsqJg)
    {
        startPage();
        List<ZhsqJg> list = zhsqJgService.selectZhsqJgList(zhsqJg);
        return getDataTable(list);
    }

    /**
     * 导出井盖列表
     */
    @RequiresPermissions("community:JG:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ZhsqJg zhsqJg)
    {
        List<ZhsqJg> list = zhsqJgService.selectZhsqJgList(zhsqJg);
        ExcelUtil<ZhsqJg> util = new ExcelUtil<ZhsqJg>(ZhsqJg.class);
        return util.exportExcel(list, "JG");
    }

    /**
     * 新增井盖
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        ZhsqJg JG = new ZhsqJg();
        mmap.put("JG", JG);
        return prefix + "/edit";
    }

    /**
     * 新增保存井盖
     */
    @RequiresPermissions("community:JG:add")
    @Log(title = "井盖", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ZhsqJg zhsqJg)
    {
        //这里的id进行修改
       // zhsqJg.setJgid(zhsqJg.getJgid().replace(",",""));
        return toAjax(zhsqJgService.insertZhsqJg(zhsqJg), zhsqJg);
    }

    /**
     * 修改井盖
     */
    @GetMapping("/edit/{jgid}")
    public String edit(@PathVariable("jgid") String jgid, ModelMap mmap)
    {
        ZhsqJg JG = zhsqJgService.selectZhsqJgById(jgid);
        mmap.put("JG", JG);
        return prefix + "/edit";
    }

    /**
     * 修改保存井盖
     */
    @RequiresPermissions("community:JG:edit")
    @Log(title = "井盖", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ZhsqJg zhsqJg)
    {
        zhsqJg.setJgid(zhsqJg.getJgid().split(",")[0]);
        return toAjax(zhsqJgService.updateZhsqJg(zhsqJg));
    }

    /**
     * 删除井盖
     */
    @RequiresPermissions("community:JG:remove")
    @Log(title = "井盖", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(zhsqJgService.deleteZhsqJgByIds(ids));
    }


    /**
     * 配置井盖
     * */
    @Log(title = "井盖", businessType = BusinessType.OTHER)
    @PostMapping( "/makeup")
    @ResponseBody
    public AjaxResult makeup(String jgid)
    {
        ZhsqJg JG = zhsqJgService.selectZhsqJgById(jgid);
        byte a=0;
        JG.setResult(a);
        zhsqJgService.updateZhsqJg(JG);
        //这里的url需要更改为配置
        String url = Global.getConfig("device.sh.pzjg");
        Map map = new HashMap();
        map.put("Sn",JG.getSn());
        map.put("ModifySn",JG.getModifysn());
        map.put("Frequency",JG.getFrequency());
        map.put("Heartbeat",JG.getHeartbeat());
        map.put("DistanceThreshold",JG.getDistancethreshold());
        map.put("IpPort",JG.getIpport());
        JSONObject json = JSONObject.toJSONObject(map);
        String result=HttpUtil.doPostJson(url, json.toString());
        return AjaxResult.success(result);
    }


    /**
     * 接收井盖的测距信息
     * */
    @ApiOperation("推送井盖的测距信息")
    @RequestMapping(value = "/api/addJgDistance",method = RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams(
            @ApiImplicitParam(dataType = "ZhsqJgDistance",name = "hsqJgDistance")
    )
    public AjaxResult addJgDisatnce(@RequestBody ZhsqJgDistance ZhsqJgDistance) {

        return AjaxResult.success(zhsqJgDistanceService.insertZhsqJgDistance(ZhsqJgDistance));
    }

    /**
     * 接收井盖的报错信息
     **/
    @ApiOperation("推送井盖的报错信息")
    @RequestMapping(value = "/api/addJgError",method = RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams(
            @ApiImplicitParam(dataType = "ZhsqJgError",name = "zhsqJgError")
    )
    public AjaxResult addJgError(@RequestBody ZhsqJgError ZhsqJgError) {
        return AjaxResult.success(zhsqJgErrorService.insertZhsqJgError(ZhsqJgError));
    }

    /**
     * 接收井盖的配置信息结果是否正确
     * */
    @ApiOperation("推送井盖的配置信息是否正确配置")
    @RequestMapping(value = "/api/addJgConfigLog",method = RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams(
            @ApiImplicitParam(dataType = "ZhsqJgConfig",name = "zhsqJgConfig")
    )
    public AjaxResult addJgConfigLog(@RequestBody ZhsqJgConfig zhsqJgConfig) {

        byte result=zhsqJgConfig.getResult();
        byte b=31;
        if((result&b)==b){
            //默认是将sn进行了更新
            ZhsqJg jg = zhsqJgService.selectZhsqJgBySn(zhsqJgConfig.getSn());
            byte a=1;
            jg.setResult(a);
            jg.setSn(jg.getModifysn());
            zhsqJgService.updateZhsqJg(jg);
        }
        return AjaxResult.success();
    }

}
