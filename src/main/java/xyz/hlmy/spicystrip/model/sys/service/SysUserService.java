package xyz.hlmy.spicystrip.model.sys.service;

import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.model.sys.dto.SysUserLoginDto;
import xyz.hlmy.spicystrip.model.sys.dto.SysUserRegisterDto;
import xyz.hlmy.spicystrip.model.sys.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author lipenghui
 * @description 针对表【sys_user(用户表)】的数据库操作Service
 * @createDate 2022-10-11 10:52:53
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 注册
     *
     * @param dto
     * @param request
     * @return
     */
    R SysUserRegister(SysUserRegisterDto dto, HttpServletRequest request);


    /**
     * 登录
     */

    R SysUserLogin(SysUserLoginDto dto);

    R addUser(SysUser user, List<Long> roleIds);

}