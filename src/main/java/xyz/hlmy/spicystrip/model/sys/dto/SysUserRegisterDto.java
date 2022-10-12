package xyz.hlmy.spicystrip.model.sys.dto;

import java.util.Date;

public class SysUserRegisterDto {

    private Long id;

    private String username;

    private String nickname;

    private String password;

    private String phone;

    private String avatar;

    private String registerIp;

    private Integer status;
    private String updateBy;

    private String email;

    private Date updateTime;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public SysUserRegisterDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public SysUserRegisterDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public SysUserRegisterDto setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SysUserRegisterDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public SysUserRegisterDto setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public SysUserRegisterDto setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getRegisterIp() {
        return registerIp;
    }

    public SysUserRegisterDto setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public SysUserRegisterDto setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public SysUserRegisterDto setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SysUserRegisterDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public SysUserRegisterDto setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public SysUserRegisterDto setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }
}
