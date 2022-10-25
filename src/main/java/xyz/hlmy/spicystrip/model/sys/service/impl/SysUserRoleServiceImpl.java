package xyz.hlmy.spicystrip.model.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import xyz.hlmy.spicystrip.model.sys.entity.SysUserRole;
import xyz.hlmy.spicystrip.model.sys.service.SysUserRoleService;
import xyz.hlmy.spicystrip.model.sys.mapper.SysUserRoleMapper;
import org.springframework.stereotype.Service;
import xyz.hlmy.spicystrip.util.StrUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lipenghui
 * @description 针对表【sys_user_role(用户与角色对应关系)】的数据库操作Service实现
 * @createDate 2022-10-25 10:22:01
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {


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
            super.remove(new LambdaQueryWrapper<SysUserRole>().eq(SysUserRole::getUser_id, userId));
            return false;
        } else {
            super.remove(new LambdaQueryWrapper<SysUserRole>().eq(SysUserRole::getUser_id, userId).notIn(SysUserRole::getRole_id, roleIds));
            List<SysUserRole> userRoles = new ArrayList<>();
            //遍历
            roleIds.forEach(roleId -> {
                SysUserRole userRole = this.getOne(new LambdaQueryWrapper<SysUserRole>().eq(SysUserRole::getRole_id, roleId).eq(SysUserRole::getUser_id, userId));
                //当前类为空则创建/则修改
                if (userRole == null) {
                    userRole = new SysUserRole();
                }
                userRole.setUser_id(userId).setRole_id(roleId);
                userRoles.add(userRole);
            });
            return this.saveOrUpdateBatch(userRoles);
        }
    }
}




