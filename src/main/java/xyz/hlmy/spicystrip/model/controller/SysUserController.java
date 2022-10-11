package xyz.hlmy.spicystrip.model.controller;



import xyz.hlmy.spicystrip.model.service.SysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


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

}

