package xyz.hlmy.spicystrip.model.sys.controller;


import org.springframework.web.bind.annotation.*;
import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.controller.BaseController;
import xyz.hlmy.spicystrip.model.sys.dto.DoLoginDto;
import xyz.hlmy.spicystrip.model.sys.dto.InsertUserDto;
import xyz.hlmy.spicystrip.model.sys.dto.UpdUserDto;
import xyz.hlmy.spicystrip.model.sys.dto.UserListsDto;
import xyz.hlmy.spicystrip.model.sys.service.SysUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 用户操作
 */
@RestController
@RequestMapping("/sys/user")
public class UserController extends BaseController {

    @Resource
    private SysUserService sysUserService;

    /**
     * 添加系统用户
     *
     * @param dto 参数
     * @return R
     */
    @PostMapping("/insert")
    public R insertSysUser(@RequestBody InsertUserDto dto) {
        log.info("UserController insertSysUser   START");
        R r = sysUserService.insertSysUser(dto);
        log.info("ActModelController insertSysUser END");
        return r;
    }


    /**
     * 登录
     *
     * @param dto 参数
     * @return R
     */
    @PostMapping("/login")
    public R doLogin(@RequestBody DoLoginDto dto, HttpServletRequest request) {
        log.info("UserController doLogin START");
        R r = sysUserService.doLogin(dto, request);
        log.info("ActModelController doLogin END");
        return r;
    }

    /**
     * 查询用户列表
     *
     * @param dto 参数
     * @return R
     */
    @PostMapping("/list")
    public R getUserLists(@RequestBody UserListsDto dto) {
        R userLists = sysUserService.getUserLists(dto);
        return userLists;
    }

    /**
     * 获取当个用户
     *
     * @param uid 用户ID
     * @return R
     */
    @PostMapping("/edit/{uid}")
    public R saveUser(@PathVariable String uid) {
        log.info("UserController saveUser START");
        R oneUser = sysUserService.getOneUser(uid);
        log.info("UserController saveUser END");
        return oneUser;
    }

    @PostMapping("/upd")
    public R updUser(@RequestBody UpdUserDto dto) {
        log.info("UserController updUser START");
        R r = this.sysUserService.updUSer(dto);
        log.info("UserController updUser END");
        return r;
    }
}
