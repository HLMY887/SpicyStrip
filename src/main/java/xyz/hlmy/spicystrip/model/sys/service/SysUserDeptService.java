package xyz.hlmy.spicystrip.model.sys.service;

import xyz.hlmy.spicystrip.model.sys.entity.SysUserDept;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author lipenghui
 * @description 针对表【sys_user_dept(用户与部门对应关系)】的数据库操作Service
 * @createDate 2022-10-25 10:22:01
 */
public interface SysUserDeptService extends IService<SysUserDept> {

    boolean saveOrUpdate(Long user_id, Long dept_id);
}
