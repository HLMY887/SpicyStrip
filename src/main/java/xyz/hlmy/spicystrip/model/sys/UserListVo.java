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
    private List<String> roleName;
}
