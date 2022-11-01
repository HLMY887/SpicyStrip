package xyz.hlmy.spicystrip.model.sys.service;

import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.model.sys.dto.RoleDto;
import xyz.hlmy.spicystrip.model.sys.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author lipenghui
 * @description 针对表【sys_role(角色表)】的数据库操作Service
 * @createDate 2022-10-25 10:22:01
 */
public interface SysRoleService extends IService<SysRole> {


    R getRolesLists(RoleDto dto);

    R saveRole(RoleDto dto);
}
