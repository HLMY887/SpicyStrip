package xyz.hlmy.spicystrip.model.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * @TableName sys_user
 */
@TableName(value ="sys_user")
public class SysUser implements Serializable {
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

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public SysUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public SysUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public SysUser setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SysUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public SysUser setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public SysUser setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getRegisterIp() {
        return registerIp;
    }

    public SysUser setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public SysUser setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public SysUser setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SysUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public SysUser setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public SysUser setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }
}