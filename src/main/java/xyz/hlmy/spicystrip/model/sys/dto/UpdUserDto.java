package xyz.hlmy.spicystrip.model.sys.dto;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

public class UpdUserDto implements Serializable {


    private Long uid;

    @NotBlank(message = "登录名称不能为空")
    private String username;
    @NotBlank(message = "姓名不能为空")
    private String real_name;
    @NotBlank(message = "密码不能为空")
    private String password;
    @NotBlank(message = "性别不能为空")
    private Integer sex;

    private String phone;

    private String tel;

    private String email;

    private String avatar;
    @NotBlank(message = "用户状态不能为空")
    private Integer status;
    @NotBlank(message = "排序号不能为空")
    private Integer sort;

    private List<Long> role_id;

    private Long dept_id;



    public String getUsername() {
        return username;
    }

    public UpdUserDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getReal_name() {
        return real_name;
    }

    public UpdUserDto setReal_name(String real_name) {
        this.real_name = real_name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UpdUserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public Integer getSex() {
        return sex;
    }

    public UpdUserDto setSex(Integer sex) {
        this.sex = sex;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UpdUserDto setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getTel() {
        return tel;
    }

    public UpdUserDto setTel(String tel) {
        this.tel = tel;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UpdUserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public UpdUserDto setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public UpdUserDto setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public UpdUserDto setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public List<Long> getRole_id() {
        return role_id;
    }

    public UpdUserDto setRole_id(List<Long> role_id) {
        this.role_id = role_id;
        return this;
    }

    public Long getDept_id() {
        return dept_id;
    }

    public UpdUserDto setDept_id(Long dept_id) {
        this.dept_id = dept_id;
        return this;
    }

    public Long getUid() {
        return uid;
    }

    public UpdUserDto setUid(Long uid) {
        this.uid = uid;
        return this;
    }
}
