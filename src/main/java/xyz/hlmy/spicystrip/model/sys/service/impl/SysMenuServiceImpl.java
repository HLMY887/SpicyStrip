package xyz.hlmy.spicystrip.model.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.util.CollectionUtils;
import xyz.hlmy.spicystrip.model.sys.entity.SysMenu;
import xyz.hlmy.spicystrip.model.sys.entity.SysUser;
import xyz.hlmy.spicystrip.model.sys.service.SysMenuService;
import xyz.hlmy.spicystrip.model.sys.mapper.SysMenuMapper;
import org.springframework.stereotype.Service;
import xyz.hlmy.spicystrip.model.sys.view.SysMenuView;
import xyz.hlmy.spicystrip.util.RequestUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lipenghui
 * @description 针对表【sys_menu(菜单表)】的数据库操作Service实现
 * @createDate 2022-10-11 10:52:52
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Resource
    private SysMenuMapper sysMenuMapper;

    /**
     * 获取目录
     *
     * @return 目录集合
     */
    @Override
    public List<SysMenuView> findUserMenu() {
        //获取到当前用户
        SysUser loginUser = RequestUtils.getLoginUser();
        if (loginUser == null) {
            return Collections.emptyList();
        }
        //根据用户id查询MenuIds
        List<Long> sysRoleMenuIds = sysMenuMapper.selectUserRoleMenuId(loginUser.getId());
        if (CollectionUtils.isEmpty(sysRoleMenuIds)) {
            return Collections.emptyList();
        }
        //去重
        LinkedHashSet<Long> orderMenuIds = new LinkedHashSet<>(sysRoleMenuIds);
        sysRoleMenuIds = new ArrayList<>(orderMenuIds);
        List<SysMenuView> result = new ArrayList<>();
        Set<Long> rootIds = new HashSet<>();
        //获取全部
        List<SysMenu> sysMenus = sysMenuMapper.selectList(null);
        //输出
        Map<Long, SysMenuView> menuViewMap = sysMenus.stream().map(SysMenu::convertToView).collect(Collectors.toMap(SysMenuView::getId, it -> it));

        for (Long menuId : sysRoleMenuIds) {
            SysMenuView sysMenuView = menuViewMap.get(menuId);
            SysMenuView tmpView = sysMenuView;
            while (tmpView.getPid() > 0 && menuViewMap.containsKey(tmpView.getPid())) {
                SysMenuView parentMenu = menuViewMap.get(sysMenuView.getPid());
                parentMenu.getChildren().add(sysMenuView);
                tmpView = parentMenu;
            }
            if (!rootIds.contains(tmpView.getId())) {
                rootIds.add(tmpView.getId());
                result.add(tmpView);
            }
        }
        return result;
    }
}




