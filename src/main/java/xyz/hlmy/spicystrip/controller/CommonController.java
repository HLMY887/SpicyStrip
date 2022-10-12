package xyz.hlmy.spicystrip.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.model.sys.dto.SysUserLoginDto;
import xyz.hlmy.spicystrip.model.sys.dto.SysUserRegisterDto;
import xyz.hlmy.spicystrip.model.sys.service.SysUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@RestController
public class CommonController {

    @Resource
    private SysUserService sysUserService;

    @PostMapping("/register")
    public R SysUserRegister(@RequestBody SysUserRegisterDto dto, HttpServletRequest request) {
        return sysUserService.SysUserRegister(dto, request);
    }


    @PostMapping("/login")
    public R Login(@RequestBody SysUserLoginDto dto) {
        return sysUserService.SysUserLogin(dto);
    }
}
