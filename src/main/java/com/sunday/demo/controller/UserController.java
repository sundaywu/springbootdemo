package com.sunday.demo.controller;

import com.sunday.demo.model.User;
import com.sunday.demo.service.UserService;
import io.swagger.annotations.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sunday on 2015/8/27.
 */
@Api(value="User Controller",description="用户表操作",tags={"用户表操作接口"})
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value = "/getAll", method=RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUser() {
        List<User> userList = userService.getAllUser();
        return userList;
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @RequestMapping(value="/add", method=RequestMethod.POST)
    @ResponseBody
    public String addUser(@RequestBody User user) {
        return userService.addUser(user).toString();
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @RequestMapping(value="/get", method= RequestMethod.POST)
    @ResponseBody
    public User getUserById(@RequestParam Integer id) {
        User user = userService.getUserById(id);
        return user;
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @RequestMapping(value="/update", method=RequestMethod.POST)
    @ResponseBody
    public String updateUserById(@RequestParam Integer id, @RequestBody User user) {
        return userService.updateUserById(id, user).toString();
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @RequestMapping(value="/del", method=RequestMethod.GET)
    @ResponseBody
    public String delUserById(@RequestParam Integer id) {
        return userService.delUserById(id).toString();
    }
}
