package xyz.hlmy.spicystrip.model.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.model.sys.entity.SysRole;
import xyz.hlmy.spicystrip.model.sys.entity.SysUserRole;
import xyz.hlmy.spicystrip.model.sys.service.SysRoleService;
import xyz.hlmy.spicystrip.model.sys.service.SysUserRoleService;
import xyz.hlmy.spicystrip.model.sys.mapper.SysUserRoleMapper;
import org.springframework.stereotype.Service;
import xyz.hlmy.spicystrip.util.StrUtil;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lipenghui
 * @description 针对表【sys_user_role(用户与角色对应关系)】的数据库操作Service实现
 * @createDate 2022-10-25 10:22:01
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

    @Resource
    private SysRoleService sysRoleService;

    /**
     * 用户角色添加
     *
     * @param roleIds 角色集合
     * @param userId  用户id
     */
    @Override
    @Transactional
    public boolean saveOrUpdateBatchUserRole(List<Long> roleIds, Long userId) {
        //验证角色集合是否为空
        if (StrUtil.isSizeEmpty(roleIds)) {
            super.remove(new LambdaQueryWrapper<SysUserRole>().eq(SysUserRole::getUserId, userId));
            return false;
        } else {
            super.remove(new LambdaQueryWrapper<SysUserRole>().eq(SysUserRole::getUserId, userId).notIn(SysUserRole::getRoleId, roleIds));
            List<SysUserRole> userRoles = new ArrayList<>();
            //遍历
            roleIds.forEach(roleId -> {
                SysUserRole userRole = this.getOne(new LambdaQueryWrapper<SysUserRole>().eq(SysUserRole::getRoleId, roleId).eq(SysUserRole::getUserId, userId));
                //当前类为空则创建/则修改
                if (userRole == null) {
                    userRole = new SysUserRole();
                }
                userRole.setUserId(userId).setRoleId(roleId);
                userRoles.add(userRole);
            });
            return this.saveOrUpdateBatch(userRoles);
        }
    }

    /**
     * 获取用户对应的角色
     *
     * @param userId 用户Id
     * @return List</>
     */
    @Override
    public List<Object> getUserRole(Long userId) {
        //拿到用户对应角色id
        List<SysUserRole> list = this.list(new LambdaQueryWrapper<SysUserRole>().eq(SysUserRole::getUserId, userId));
        if (!StrUtil.isSizeEmpty(list)) {
            List<Object> roleLists = new ArrayList<>();
            //遍历对应角色id
            list.forEach(userRole -> {
                //拿到对应角色的类
                SysRole one = this.sysRoleService.getOne(new LambdaQueryWrapper<SysRole>().eq(SysRole::getId, userRole.getRoleId()));
                roleLists.add(one);
            });
            return roleLists;
        }
        return new ArrayList<>();
    }
}




