package xyz.hlmy.spicystrip.model.sys.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.common.Snowflake;
import xyz.hlmy.spicystrip.model.sys.dto.SysUserLoginDto;
import xyz.hlmy.spicystrip.model.sys.dto.SysUserRegisterDto;
import xyz.hlmy.spicystrip.model.sys.entity.SysUser;
import xyz.hlmy.spicystrip.model.sys.entity.UserInfo;
import xyz.hlmy.spicystrip.model.sys.service.SysMenuService;
import xyz.hlmy.spicystrip.model.sys.service.SysUserService;
import xyz.hlmy.spicystrip.model.sys.mapper.SysUserMapper;
import org.springframework.stereotype.Service;
import xyz.hlmy.spicystrip.model.sys.view.SysMenuView;
import xyz.hlmy.spicystrip.model.sys.view.UserLoginView;
import xyz.hlmy.spicystrip.util.IPUtil;
import xyz.hlmy.spicystrip.util.RequestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author lipenghui
 * @description 针对表【sys_user(用户表)】的数据库操作Service实现
 * @createDate 2022-10-11 10:52:53
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysMenuService sysMenuService;

    @Override
    @Transactional
    public R SysUserRegister(SysUserRegisterDto dto, HttpServletRequest request) {
        //获取雪花算法
        Snowflake id = new Snowflake();
        SysUser sysUser = new SysUser().setId(id.nextId()).setUsername(dto.getUsername()).setNickname(dto.getNickname()).setPassword(SaSecureUtil.sha256(dto.getPassword())).setPhone(dto.getPhone()).setAvatar("https://www.gravatar.com/avatar/00000000000000000000000000000000?d=mp&f=y").setRegisterIp(IPUtil.getIP(request)).setEmail(dto.getEmail()).setCreateTime(new Date());
        int insert = sysUserMapper.insert(sysUser);
        if (insert != 0) {
            return R.ok();
        }
        return R.err(400, "注册失败");
    }

    @Override
    public R SysUserLogin(SysUserLoginDto dto) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("nickname", dto.getNickname());
        queryWrapper.eq("password", SaSecureUtil.sha256(dto.getPassword()));
        SysUser sysUser = sysUserMapper.selectOne(queryWrapper);
        if (sysUser != null) {
            StpUtil.login(sysUser.getId());
            RequestUtils.putLoginUser(sysUser);
            List<SysMenuView> menus = sysMenuService.findUserMenu();
            UserLoginView userLoginSuccessView = new UserLoginView();
            userLoginSuccessView.setMenus(menus);
            UserInfo userInfo = new UserInfo();
            BeanUtils.copyProperties(sysUser, userInfo);
            userLoginSuccessView.setUserInfo(userInfo);
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            userLoginSuccessView.setToken(tokenInfo.getTokenValue());
            return R.ok(userLoginSuccessView);
        } else {
            return R.err(400, "帐号或密码不正确");
        }
    }

    @Override
    public R addUser(SysUser user, List<Long> roleIds) {
        return null;
    }
}




