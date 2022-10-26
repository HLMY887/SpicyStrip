package xyz.hlmy.spicystrip.model.sys.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Select;
import xyz.hlmy.spicystrip.model.sys.UserListVo;
import xyz.hlmy.spicystrip.model.sys.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author lipenghui
 * @description 针对表【sys_user(用户表)】的数据库操作Mapper
 * @createDate 2022-10-25 09:51:36
 * @Entity xyz.hlmy.spicystrip.model.entity.SysUser
 */
public interface SysUserMapper extends BaseMapper<SysUser> {


    @Select("SELECT \n" +
            "u.uid,\n" +
            "u.user_name,\n" +
            "u.real_name,\n" +
            "u.sex,\n" +
            "u.phone,\n" +
            "u.tel,\n" +
            "u.email,\n" +
            "u.avatar,\n" +
            "u.status,\n" +
            "u.sort,\n" +
            "u.del_flag,\n" +
            "d.name AS dept_name \n" +
            " FROM sys_user u, sys_user_dept ud,sys_dept d\n" +
            "WHERE\n" +
            " u.uid=ud.user_id\n" +
            "AND ud.dept_id=d.id")
    public List<UserListVo> getUserLists(QueryWrapper<Object> queryWrapper);
}




