package xyz.hlmy.spicystrip.model.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import xyz.hlmy.spicystrip.model.entity.SysPermission;
import xyz.hlmy.spicystrip.model.service.SysPermissionService;
import xyz.hlmy.spicystrip.model.mapper.SysPermissionMapper;
import org.springframework.stereotype.Service;

/**
* @author lipenghui
* @description 针对表【sys_permission(权限表)】的数据库操作Service实现
* @createDate 2022-10-11 10:52:53
*/
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission>
    implements SysPermissionService{

}




