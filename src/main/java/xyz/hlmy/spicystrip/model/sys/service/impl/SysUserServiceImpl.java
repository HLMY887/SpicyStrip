package xyz.hlmy.spicystrip.model.sys.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.common.Snowflake;
import xyz.hlmy.spicystrip.model.sys.UserListVo;
import xyz.hlmy.spicystrip.model.sys.entity.SysLogin;
import xyz.hlmy.spicystrip.model.sys.service.*;
import xyz.hlmy.spicystrip.model.sys.dto.DoLoginDto;
import xyz.hlmy.spicystrip.model.sys.dto.InsertUserDto;
import xyz.hlmy.spicystrip.model.sys.dto.UserListsDto;
import xyz.hlmy.spicystrip.model.sys.entity.SysDept;
import xyz.hlmy.spicystrip.model.sys.entity.SysUser;
import xyz.hlmy.spicystrip.model.sys.mapper.SysUserMapper;
import org.springframework.stereotype.Service;
import xyz.hlmy.spicystrip.util.IPUtil;
import xyz.hlmy.spicystrip.util.OsTypeUtil;
import xyz.hlmy.spicystrip.util.StrUtil;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * @author lipenghui
 * @description 针对表【sys_user(用户表)】的数据库操作Service实现
 * @createDate 2022-10-25 09:51:36
 */
@Slf4j
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {


    @Resource
    private SysUserRoleService sysUserRoleService;

    @Resource
    private SysUserDeptService sysUserDeptService;

    @Resource
    private SysLoginService sysLoginService;

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysRoleService sysRoleService;

    /**
     * 新增用户
     *
     * @param dto 参数
     * @return R
     */
    @Override
    @Transactional
    public R insertSysUser(InsertUserDto dto) {
        if (this.checkSysUsername(dto.getUsername())) {
            return R.err(400, "用户名已存在");
        }
        //声明雪花算法
        Snowflake snowflake = new Snowflake();
        long userId = snowflake.nextId();
        //判定创建
        boolean user = this.saveOrUpdate(new SysUser().setUid(userId).setUserName(dto.getUsername()).setRealName(dto.getReal_name()).setPassword(SaSecureUtil.sha256(dto.getPassword())).setSex(dto.getSex()).setPhone(dto.getPhone()).setTel(dto.getTel()).setEmail(dto.getEmail()).setAvatar(dto.getAvatar()).setStatus(dto.getStatus()));
        boolean userDept = this.sysUserDeptService.saveOrUpdate(userId, dto.getDept_id());
        boolean userRole = this.sysUserRoleService.saveOrUpdateBatchUserRole(dto.getRole_id(), userId);
        if (user && userDept && userRole) {
            return R.ok();
        }
        return R.err(400, "创建用户失败");
    }

    /**
     * 用户登录
     *
     * @param dto 参数
     * @return R
     */
    @Override
    public R doLogin(DoLoginDto dto, HttpServletRequest request) {
        SysUser sysUser = this.getOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUserName, dto.getUser_name()).eq(SysUser::getPassword, SaSecureUtil.sha256(dto.getPassword())));
        if (sysUser != null) {
            String ip = IPUtil.getIP(request);
            String osType = OsTypeUtil.getOSType(request);
            boolean orUpdate = this.sysLoginService.saveOrUpdate(new SysLogin().setUid(sysUser.getUid()).setuIp(ip).setuName(sysUser.getUserName()).setuType(osType));
            if (orUpdate) {
                //设置登录
                StpUtil.login(sysUser.getUid());
                //保存用户信息到Session
                StpUtil.getSession(true).set(SaSession.USER, sysUser);
                //获取角色
                List<Object> userRoleLists = this.sysUserRoleService.getUserRole(sysUser.getUid());
                //获取部门
                List<SysDept> userDeptLists = this.sysUserDeptService.getUserDept(sysUser.getUid());
                HashMap<String, Object> data = new HashMap<>();
                data.put("user", sysUser);
                data.put("role", userRoleLists);
                data.put("dept", userDeptLists);
                data.put("token", StpUtil.getTokenInfo());
                return R.ok(data);
            }
            return R.err(400, "用户不存在");
        }
        return R.err(400, "用户不存在");
    }

    /**
     * 获取用户列表
     *
     * @param dto 参数
     * @return R
     */
    @Override
    public R getUserLists(UserListsDto dto) {
        QueryWrapper<Object> queryWrapper = new QueryWrapper<>();
        if (!StrUtil.isEmpty(dto.getUsername())) {
            queryWrapper.eq("u.user_name", dto.getUsername());
        }
        if (!StrUtil.isEmpty(dto.getRealname())) {
            queryWrapper.eq("u.real_name", dto.getRealname());
        }
        queryWrapper.eq("u.status", dto.getStatus());
        //拿到用户信息
        List<UserListVo> userLists = this.sysUserMapper.getUserLists(queryWrapper);
        if (!StrUtil.isSizeEmpty(userLists)) {
            //遍历用户
            userLists.forEach(user -> {
                //拿到用户对应的角色
                List<Object> userRole = this.sysUserRoleService.getUserRole(user.getuId());
                user.setRoleName(userRole);
            });
            return R.page(userLists, userLists.size());
        }
        return R.err(400, "为查询到用户");
    }


    /**
     * 验证登录名是否存在
     *
     * @param userName 登录名
     * @return boolean
     */
    private boolean checkSysUsername(String userName) {
        SysUser one = super.getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUserName, userName).last("limit 1"));
        return one != null;
    }
}




