package xyz.hlmy.spicystrip.model.sys.service;

import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.model.sys.dto.DeptDto;
import xyz.hlmy.spicystrip.model.sys.entity.SysDept;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author lipenghui
 * @description 针对表【sys_dept(部门表)】的数据库操作Service
 * @createDate 2022-10-25 10:06:13
 */
public interface SysDeptService extends IService<SysDept> {


    boolean checkSysUsername(Long dept_id);

    R getDeptLists(DeptDto dto);
}
