package xyz.hlmy.spicystrip.model.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

/**
 * 用户表
 *
 * @TableName sys_user
 */
@TableName(value = "sys_user")
@Data
public class SysUser implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "uid")
    private Long uid;

    /**
     * 登录名
     */
    @TableField(value = "user_name")
    private String userName;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 姓名
     */
    @TableField(value = "real_name")
    private String realName;

    /**
     * 性别。0：未知；1：男；2：女
     */
    @TableField(value = "sex")
    private Integer sex;

    /**
     * 手机号码
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 固定电话
     */
    @TableField(value = "tel")
    private String tel;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 用户头像
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 用户状态。0：正常；1：禁用
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 排序。值越小越靠前
     */
    @TableField(value = "sort")
    private Integer sort;

    /**
     * 删除标识。0：未删除；1：已删除
     */
    @TableField(value = "del_flag")
    private Integer delFlag;

    /**
     * 创建人
     */
    @TableField(value = "create_by")
    private Long createBy;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public Long getUid() {
        return uid;
    }

    public SysUser setUid(Long uid) {
        this.uid = uid;
        return this;
    }



    public String getPassword() {
        return password;
    }

    public SysUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public SysUser setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getRealName() {
        return realName;
    }

    public SysUser setRealName(String realName) {
        this.realName = realName;
        return this;
    }

    public Integer getSex() {
        return sex;
    }

    public SysUser setSex(Integer sex) {
        this.sex = sex;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public SysUser setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getTel() {
        return tel;
    }

    public SysUser setTel(String tel) {
        this.tel = tel;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SysUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public SysUser setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public SysUser setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public SysUser setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public SysUser setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public SysUser setCreateBy(Long createBy) {
        this.createBy = createBy;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public SysUser setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public SysUser setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }
}
