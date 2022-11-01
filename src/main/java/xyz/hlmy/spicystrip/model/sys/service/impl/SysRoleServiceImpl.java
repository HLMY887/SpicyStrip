package xyz.hlmy.spicystrip.model.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.model.sys.dto.RoleDto;
import xyz.hlmy.spicystrip.model.sys.entity.SysRole;
import xyz.hlmy.spicystrip.model.sys.service.SysRoleService;
import xyz.hlmy.spicystrip.model.sys.mapper.SysRoleMapper;
import org.springframework.stereotype.Service;
import xyz.hlmy.spicystrip.util.StrUtil;

import java.util.List;

/**
 * @author lipenghui
 * @description 针对表【sys_role(角色表)】的数据库操作Service实现
 * @createDate 2022-10-25 10:22:01
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    /**
     * 获取角色列表
     *
     * @param dto 参数
     * @return R
     */
    @Override
    public R getRolesLists(RoleDto dto) {
        LambdaQueryWrapper<SysRole> queryWrapper = new LambdaQueryWrapper<>();
        if (!StrUtil.isEmpty(dto.getRole_name())) {
            queryWrapper.eq(SysRole::getName, dto.getRole_name());
        }
        queryWrapper.eq(SysRole::getType, 0);
        List<SysRole> list = this.list(queryWrapper);
        if (list != null) {
            return R.ok(list);
        }
        return R.err(400, "获取失败");
    }

    /**
     * 添加
     *
     * @param dto 参数
     * @return R
     */
    @Override
    public R saveRole(RoleDto dto) {
        boolean save = this.save(new SysRole().setName(dto.getRole_name()).setType(dto.getRole_type()).setRemark(dto.getRole_remark()).setParentId(dto.getParent_id()));
        return save ? R.ok() : R.err(400, "添加失败");
    }

}




