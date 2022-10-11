package xyz.hlmy.spicystrip.model.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import xyz.hlmy.spicystrip.model.view.SysMenuView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * @TableName sys_menu
 */
@TableName(value = "sys_menu")
public class SysMenu implements Serializable {
    private Long id;

    private String title;

    private String name;

    private String route;

    private String icon;

    private Integer close;

    private Integer hidden;

    private String updateBy;

    private String createBy;

    private Long pid;

    private Date updateTime;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getClose() {
        return close;
    }

    public void setClose(Integer close) {
        this.close = close;
    }

    public Integer getHidden() {
        return hidden;
    }

    public void setHidden(Integer hidden) {
        this.hidden = hidden;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public SysMenuView convertToView() {
        SysMenuView view = new SysMenuView();
        view.setId(id);
        view.setTitle(title);
        view.setName(name);
        view.setRoute(route);
        view.setIcon(icon);
        view.setClose(close);
        view.setHidden(hidden);
        view.setPid(pid);
        view.setChildren(new ArrayList<>());
        return view;
    }
}