package xyz.hlmy.spicystrip.model.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.model.sys.dto.DeptDto;
import xyz.hlmy.spicystrip.model.sys.entity.SysDept;
import xyz.hlmy.spicystrip.model.sys.service.SysDeptService;
import xyz.hlmy.spicystrip.model.sys.mapper.SysDeptMapper;
import org.springframework.stereotype.Service;

/**
 * @author lipenghui
 * @description 针对表【sys_dept(部门表)】的数据库操作Service实现
 * @createDate 2022-10-25 10:06:13
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {


    /**
     * 验证是否存在
     *
     * @param dept_id 部门ID
     * @return boolean
     */
    @Override
    public boolean checkSysUsername(Long dept_id) {
        SysDept one = this.getOne(new LambdaQueryWrapper<SysDept>().eq(SysDept::getDeptId, dept_id));
        return one != null;
    }

    /**
     * 获取部门列表
     *
     * @param dto  参数
     * @return R
     */
    @Override
    public R getDeptLists(DeptDto dto) {
        return null;
    }


}




