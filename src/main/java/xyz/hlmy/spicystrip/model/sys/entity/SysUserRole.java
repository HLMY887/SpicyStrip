package xyz.hlmy.spicystrip.model.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 用户与角色对应关系
 * @TableName sys_user_role
 */
@TableName(value ="sys_user_role")
@Data
public class SysUserRole implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long user_id;

    /**
     * 角色ID
     */
    @TableField(value = "role_id")
    private Long role_id;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime create_time;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public SysUserRole setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUser_id() {
        return user_id;
    }

    public SysUserRole setUser_id(Long user_id) {
        this.user_id = user_id;
        return this;
    }

    public Long getRole_id() {
        return role_id;
    }

    public SysUserRole setRole_id(Long role_id) {
        this.role_id = role_id;
        return this;
    }

    public LocalDateTime getCreate_time() {
        return create_time;
    }

    public SysUserRole setCreate_time(LocalDateTime create_time) {
        this.create_time = create_time;
        return this;
    }
}
