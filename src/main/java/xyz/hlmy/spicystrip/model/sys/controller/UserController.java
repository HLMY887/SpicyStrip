package xyz.hlmy.spicystrip.model.sys.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.controller.BaseController;
import xyz.hlmy.spicystrip.model.sys.dto.InsertUserDto;
import xyz.hlmy.spicystrip.model.sys.service.SysUserService;

import javax.annotation.Resource;

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

}
