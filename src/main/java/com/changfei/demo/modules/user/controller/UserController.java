package com.changfei.demo.modules.user.controller;


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
    public List<User> getList() {
        return userService.list();
    }

    @ApiOperation("获取列表")
    @PostMapping("/getMap")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名字", paramType = "query", dataType="String"),
            @ApiImplicitParam(name = "age", value = "年龄", paramType = "query", dataType="Integer"),
            @ApiImplicitParam(name = "sex", value = "性别", paramType = "query", dataType="String")
    })
    public List<User> getListByMap(@ApiIgnore @RequestParam Map<String, Object> params) {
        return userService.getListByMap(params);
    }

}
