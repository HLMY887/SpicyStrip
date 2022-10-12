package xyz.hlmy.spicystrip.model.sys.mapper;

import org.apache.ibatis.annotations.Select;
import xyz.hlmy.spicystrip.model.sys.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author lipenghui
 * @description 针对表【sys_menu(菜单表)】的数据库操作Mapper
 * @createDate 2022-10-11 10:52:52
 * @Entity xyz.hlmy.spicystrip.model.entity.SysMenu
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 根据uid查询当前用户的目录
     *
     * @param uid 用户id
     * @return List
     */
    @Select("SELECT rm.menu_id FROM sys_user_role ur INNER JOIN sys_role_menu rm ON ur.role_id = rm.role_id AND ur.uid = #{uid}")
    List<Long> selectUserRoleMenuId(Long uid);
}




