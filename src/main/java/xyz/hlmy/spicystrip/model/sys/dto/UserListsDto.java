package xyz.hlmy.spicystrip.model.sys.dto;

import lombok.Data;
import xyz.hlmy.spicystrip.model.actviti.entity.PageInfo;

@Data
public class UserListsDto {

    private String username;

    private String realname;

    private Integer status;

    private PageInfo pageinfo;

    public String getUsername() {
        return username;
    }

    public UserListsDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getRealname() {
        return realname;
    }

    public UserListsDto setRealname(String realname) {
        this.realname = realname;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public UserListsDto setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public PageInfo getPageinfo() {
        return pageinfo;
    }

    public UserListsDto setPageinfo(PageInfo pageinfo) {
        this.pageinfo = pageinfo;
        return this;
    }
}
