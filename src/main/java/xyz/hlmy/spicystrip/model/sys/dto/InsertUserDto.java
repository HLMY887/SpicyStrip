package xyz.hlmy.spicystrip.model.sys.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Data
public class InsertUserDto implements Serializable {
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

    public InsertUserDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getReal_name() {
        return real_name;
    }

    public InsertUserDto setReal_name(String real_name) {
        this.real_name = real_name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public InsertUserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public Integer getSex() {
        return sex;
    }

    public InsertUserDto setSex(Integer sex) {
        this.sex = sex;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public InsertUserDto setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getTel() {
        return tel;
    }

    public InsertUserDto setTel(String tel) {
        this.tel = tel;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public InsertUserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public InsertUserDto setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public InsertUserDto setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public InsertUserDto setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public List<Long> getRole_id() {
        return role_id;
    }

    public InsertUserDto setRole_id(List<Long> role_id) {
        this.role_id = role_id;
        return this;
    }

    public Long getDept_id() {
        return dept_id;
    }

    public InsertUserDto setDept_id(Long dept_id) {
        this.dept_id = dept_id;
        return this;
    }

    @Override
    public String toString() {
        return "InsertUserDto{" +
                "username='" + username + '\'' +
                ", real_name='" + real_name + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", status=" + status +
                ", sort=" + sort +
                '}';
    }
}
