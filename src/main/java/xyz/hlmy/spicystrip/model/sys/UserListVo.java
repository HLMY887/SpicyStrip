package xyz.hlmy.spicystrip.model.sys;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

/**
 * @Author snd shun
 * @Creation 2022 2022/10/26 20:17
 * @Desc:
 */
@Data
public class UserListVo {

    /**
     * 用户Id
     */
    @TableField(value = "uid")
    private Long uId;

    @TableField(value = "user_name")
    private String userName;
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

    @TableField(value = "dept_name")
    private String deptName;

    @TableField(value = "role_name")
    private List<Object> roleName;

    public Long getuId() {
        return uId;
    }

    public UserListVo setuId(Long uId) {
        this.uId = uId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserListVo setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getRealName() {
        return realName;
    }

    public UserListVo setRealName(String realName) {
        this.realName = realName;
        return this;
    }

    public Integer getSex() {
        return sex;
    }

    public UserListVo setSex(Integer sex) {
        this.sex = sex;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserListVo setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getTel() {
        return tel;
    }

    public UserListVo setTel(String tel) {
        this.tel = tel;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserListVo setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public UserListVo setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public UserListVo setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public UserListVo setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public UserListVo setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public String getDeptName() {
        return deptName;
    }

    public UserListVo setDeptName(String deptName) {
        this.deptName = deptName;
        return this;
    }

    public List<Object> getRoleName() {
        return roleName;
    }

    public UserListVo setRoleName(List<Object> roleName) {
        this.roleName = roleName;
        return this;
    }
}
