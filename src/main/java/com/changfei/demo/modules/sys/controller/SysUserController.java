package com.changfei.demo.modules.sys.controller;


import com.changfei.demo.common.constant.Constant;
import com.changfei.demo.common.page.PageData;
import com.changfei.demo.common.utils.Result;
import com.changfei.demo.modules.sys.entity.SysUser;
import com.changfei.demo.modules.sys.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;

/**
* <p>
*  前端控制器
* </p>
*
* @author changfei
* @since 2020-11-05
*/
@RestController
@RequestMapping("/sys/sys-user")
@Api(tags="")
public class SysUserController {

    @Autowired
    private ISysUserService baseService;


    @ApiOperation("获取分页数据")
    @PostMapping("/getPageByMap")
    @ApiImplicitParams({
    @ApiImplicitParam(name = Constant.PAGE_NO, value = "当前页码", paramType = "query", dataType="String"),
    @ApiImplicitParam(name = Constant.LIMIT, value = "每页记录数", paramType = "query", dataType="String"),
    @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String"),
    @ApiImplicitParam(name = Constant.ORDER, value = "排序方式(asc desc)", paramType = "query", dataType="String")
    })
    public Result< PageData<SysUser>> getPageByMap(@ApiIgnore @RequestParam Map< String, Object> params) {
    PageData<SysUser> data=baseService.getPageByMap(params);
        return new Result< PageData<SysUser>>().ok(data);
    }

    @ApiOperation("保存")
    @PostMapping("/save")
    public Result<SysUser> save(SysUser entity){
        boolean b=baseService.saveOrUpdate(entity);
        if(b){
            return new Result<SysUser>().ok(entity);
        }
        return new Result<SysUser>().error("保存失败");
    }

    @ApiOperation("获取单条数据")
    @PostMapping("/get/{id}")
    public Result<SysUser> get(@PathVariable String id){
        SysUser entity=baseService.getById(id);
        return new Result<SysUser>().ok(entity);
    }
}
