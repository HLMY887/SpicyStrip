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
    private String user_name;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 姓名
     */
    @TableField(value = "real_name")
    private String real_name;

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
    private Integer del_flag;

    /**
     * 创建人
     */
    @TableField(value = "create_by")
    private Long create_by;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private LocalDateTime update_time;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime create_time;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public Long getUid() {
        return uid;
    }

    public SysUser setUid(Long uid) {
        this.uid = uid;
        return this;
    }

    public String getUser_name() {
        return user_name;
    }

    public SysUser setUser_name(String user_name) {
        this.user_name = user_name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SysUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getReal_name() {
        return real_name;
    }

    public SysUser setReal_name(String real_name) {
        this.real_name = real_name;
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

    public Integer getDel_flag() {
        return del_flag;
    }

    public SysUser setDel_flag(Integer del_flag) {
        this.del_flag = del_flag;
        return this;
    }

    public Long getCreate_by() {
        return create_by;
    }

    public SysUser setCreate_by(Long create_by) {
        this.create_by = create_by;
        return this;
    }

    public LocalDateTime getUpdate_time() {
        return update_time;
    }

    public SysUser setUpdate_time(LocalDateTime update_time) {
        this.update_time = update_time;
        return this;
    }

    public LocalDateTime getCreate_time() {
        return create_time;
    }

    public SysUser setCreate_time(LocalDateTime create_time) {
        this.create_time = create_time;
        return this;
    }
}