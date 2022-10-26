package xyz.hlmy.spicystrip.model.sys.service;

import xyz.hlmy.spicystrip.model.sys.entity.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author lipenghui
 * @description 针对表【sys_user_role(用户与角色对应关系)】的数据库操作Service
 * @createDate 2022-10-25 10:22:01
 */
public interface SysUserRoleService extends IService<SysUserRole> {


    boolean saveOrUpdateBatchUserRole(List<Long> roleIds, Long userId);

    List<Object> getUserRole(Long UserId);


}
