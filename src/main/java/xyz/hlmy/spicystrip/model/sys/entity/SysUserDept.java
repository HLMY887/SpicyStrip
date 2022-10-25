package xyz.hlmy.spicystrip.model.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 用户与部门对应关系
 * @TableName sys_user_dept
 */
@TableName(value ="sys_user_dept")
@Data
public class SysUserDept implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long user_id;

    /**
     * 部门ID
     */
    @TableField(value = "dept_id")
    private Long dept_id;

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

    public SysUserDept setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUser_id() {
        return user_id;
    }

    public SysUserDept setUser_id(Long user_id) {
        this.user_id = user_id;
        return this;
    }

    public Long getDept_id() {
        return dept_id;
    }

    public SysUserDept setDept_id(Long dept_id) {
        this.dept_id = dept_id;
        return this;
    }

    public LocalDateTime getCreate_time() {
        return create_time;
    }

    public SysUserDept setCreate_time(LocalDateTime create_time) {
        this.create_time = create_time;
        return this;
    }
}
