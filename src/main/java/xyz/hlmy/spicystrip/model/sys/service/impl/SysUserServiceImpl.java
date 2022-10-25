package xyz.hlmy.spicystrip.model.sys.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.common.Snowflake;
import xyz.hlmy.spicystrip.model.sys.dto.InsertUserDto;
import xyz.hlmy.spicystrip.model.sys.entity.SysDept;
import xyz.hlmy.spicystrip.model.sys.entity.SysUser;
import xyz.hlmy.spicystrip.model.sys.entity.SysUserDept;
import xyz.hlmy.spicystrip.model.sys.mapper.SysUserRoleMapper;
import xyz.hlmy.spicystrip.model.sys.service.SysDeptService;
import xyz.hlmy.spicystrip.model.sys.service.SysUserDeptService;
import xyz.hlmy.spicystrip.model.sys.service.SysUserRoleService;
import xyz.hlmy.spicystrip.model.sys.service.SysUserService;
import xyz.hlmy.spicystrip.model.sys.mapper.SysUserMapper;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * @author lipenghui
 * @description 针对表【sys_user(用户表)】的数据库操作Service实现
 * @createDate 2022-10-25 09:51:36
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {


    @Resource
    private SysUserRoleService sysUserRoleService;

    @Resource
    private SysUserDeptService sysUserDeptService;

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
        boolean user = this.saveOrUpdate(new SysUser().setUid(userId).setUser_name(dto.getUsername()).setReal_name(dto.getReal_name()).setPassword(SaSecureUtil.sha256(dto.getPassword())).setSex(dto.getSex()).setPhone(dto.getPhone()).setTel(dto.getTel()).setEmail(dto.getEmail()).setAvatar(dto.getAvatar()).setStatus(dto.getStatus()));
        boolean userDept = this.sysUserDeptService.saveOrUpdate(userId, dto.getDept_id());
        boolean userRole = this.sysUserRoleService.saveOrUpdateBatchUserRole(dto.getRole_id(), userId);
        if (user && userDept && userRole) {
            return R.ok();
        }
        return R.err(400, "创建用户失败");
    }


    /**
     * 验证登录名是否存在
     *
     * @param userName 登录名
     * @return boolean
     */
    private boolean checkSysUsername(String userName) {
        SysUser one = super.getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUser_name, userName).last("limit 1"));
        return one != null;
    }
}




