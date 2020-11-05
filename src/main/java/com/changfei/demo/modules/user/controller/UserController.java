package com.changfei.demo.modules.user.controller;


import com.changfei.demo.common.constant.Constant;
import com.changfei.demo.common.page.PageData;
import com.changfei.demo.common.utils.Result;
import com.changfei.demo.modules.user.entity.User;
import com.changfei.demo.modules.user.service.IUserService;
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
* @since 2020-10-31
*/
@RestController
@RequestMapping("/user/user")
@Api(tags="测试")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation("获取列表")
    @GetMapping("/getList")
    public Result<List<User>> getList() {
        List<User> list=userService.list();
        return new Result<List<User>>().ok(list);
    }

    @ApiOperation("获取列表")
    @PostMapping("/getListByMap")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名字", paramType = "query", dataType="String"),
            @ApiImplicitParam(name = "age", value = "年龄", paramType = "query", dataType="Integer"),
            @ApiImplicitParam(name = "sex", value = "性别", paramType = "query", dataType="String")
    })
    public Result<List<User>> getListByMap(@ApiIgnore @RequestParam Map<String, Object> params) {
        List<User> list=userService.getListByMap(params);
        return new Result<List<User>>().ok(list);
    }

    @ApiOperation("获取分页数据")
    @PostMapping("/getPageByMap")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名字", paramType = "query", dataType="String"),
            @ApiImplicitParam(name = "age", value = "年龄", paramType = "query", dataType="Integer"),
            @ApiImplicitParam(name = "sex", value = "性别", paramType = "query", dataType="String"),
            @ApiImplicitParam(name = Constant.PAGE_NO, value = "当前页码", paramType = "query", dataType="String"),
            @ApiImplicitParam(name = Constant.LIMIT, value = "每页记录数", paramType = "query", dataType="String"),
            @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String"),
            @ApiImplicitParam(name = Constant.ORDER, value = "排序方式(asc desc)", paramType = "query", dataType="String")
    })
    public Result<PageData<User>> getPageByMap(@ApiIgnore @RequestParam Map<String, Object> params) {
        PageData<User> data=userService.getPageByMap(params);
        return new Result<PageData<User>>().ok(data);
    }

    @ApiOperation("保存")
    @PostMapping("/save")
    public Result<User> save(User user){
        boolean b=userService.saveOrUpdate(user);
        if(b){
            return new Result<User>().ok(user);
        }
        return new Result<User>().error("保存失败");
    }

    @ApiOperation("获取单条数据")
    @PostMapping("/get/{id}")
    public Result<User> get(@PathVariable String id){
        User user=userService.getById(id);
        return new Result<User>().ok(user);
    }

}
