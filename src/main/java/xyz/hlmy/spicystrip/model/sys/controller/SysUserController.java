package xyz.hlmy.spicystrip.model.sys.controller;


import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.model.sys.entity.SysUser;
import xyz.hlmy.spicystrip.model.sys.service.SysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * 用户表(SysUser)表控制层
 *
 * @author HLMY
 * @since 2022-10-11 09:24:55
 */
@RestController
@RequestMapping("/sys")
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    /**
     * 添加用户
     *
     * @param user
     * @param roleIds
     * @return
     */
    @PostMapping(value = "add")
    public R add(SysUser user, @RequestParam("roleIds") List<Long> roleIds) {
        sysUserService.addUser(user, roleIds);
        return R.ok();
    }
}

