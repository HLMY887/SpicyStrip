package xyz.hlmy.spicystrip.model.view;

import xyz.hlmy.spicystrip.model.entity.UserInfo;

import java.util.List;

public class UserLoginView {
    private List<SysMenuView> menus;

    private UserInfo userInfo;

    private String token;

    public List<SysMenuView> getMenus() {
        return menus;
    }

    public UserLoginView setMenus(List<SysMenuView> menus) {
        this.menus = menus;
        return this;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public UserLoginView setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
        return this;
    }

    public String getToken() {
        return token;
    }

    public UserLoginView setToken(String token) {
        this.token = token;
        return this;
    }
}
