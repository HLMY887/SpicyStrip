package xyz.hlmy.spicystrip.model.sys.service;

import xyz.hlmy.spicystrip.model.sys.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import xyz.hlmy.spicystrip.model.sys.view.SysMenuView;

import java.util.List;

/**
 * @author lipenghui
 * @description 针对表【sys_menu(菜单表)】的数据库操作Service
 * @createDate 2022-10-11 10:52:52
 */
public interface SysMenuService extends IService<SysMenu> {


    List<SysMenuView> findUserMenu();
}
