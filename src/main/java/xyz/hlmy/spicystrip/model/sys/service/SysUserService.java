package xyz.hlmy.spicystrip.model.sys.service;

import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.model.sys.dto.DoLoginDto;
import xyz.hlmy.spicystrip.model.sys.dto.InsertUserDto;
import xyz.hlmy.spicystrip.model.sys.dto.UserListsDto;
import xyz.hlmy.spicystrip.model.sys.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lipenghui
 * @description 针对表【sys_user(用户表)】的数据库操作Service
 * @createDate 2022-10-25 09:51:36
 */
public interface SysUserService extends IService<SysUser> {


    R insertSysUser(InsertUserDto dto);

    R doLogin(DoLoginDto dto, HttpServletRequest request);


    R getUserLists(UserListsDto dto);
}
