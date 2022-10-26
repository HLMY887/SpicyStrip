package xyz.hlmy.spicystrip.model.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import xyz.hlmy.spicystrip.model.sys.entity.SysDept;
import xyz.hlmy.spicystrip.model.sys.entity.SysUserDept;
import xyz.hlmy.spicystrip.model.sys.service.SysDeptService;
import xyz.hlmy.spicystrip.model.sys.service.SysUserDeptService;
import xyz.hlmy.spicystrip.model.sys.mapper.SysUserDeptMapper;
import org.springframework.stereotype.Service;
import xyz.hlmy.spicystrip.util.StrUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lipenghui
 * @description 针对表【sys_user_dept(用户与部门对应关系)】的数据库操作Service实现
 * @createDate 2022-10-25 10:22:01
 */
@Service
public class SysUserDeptServiceImpl extends ServiceImpl<SysUserDeptMapper, SysUserDept> implements SysUserDeptService {

    @Resource
    private SysDeptService sysDeptService;


    /**
     * 用户添加部门关系
     *
     * @param user_id 用户id
     * @param dept_id 部门id
     * @return
     */
    @Override
    public boolean saveOrUpdate(Long user_id, Long dept_id) {
        //验证是否存在
        boolean dept = sysDeptService.checkSysUsername(dept_id);
        if (dept) {
            return this.saveOrUpdate(new SysUserDept().setUserId(user_id).setDeptId(dept_id));
        }
        return false;
    }

    /**
     * 根据用户获取到对应的部门
     *
     * @param userId 用户Id
     * @return List
     */
    @Override
    public List<SysDept> getUserDept(Long userId) {
        List<SysUserDept> userDeptList = this.list(new LambdaQueryWrapper<SysUserDept>().eq(SysUserDept::getUserId, userId));
        if (!StrUtil.isSizeEmpty(userDeptList)) {
            List<SysDept> deptList = new ArrayList<>();
            userDeptList.forEach(userDept -> {
                SysDept sysDept = this.sysDeptService.getOne(new LambdaQueryWrapper<SysDept>().eq(SysDept::getId, userDept.getDeptId()));
                deptList.add(sysDept);
            });
            return deptList;
        }
        return new ArrayList<>();
    }
}




