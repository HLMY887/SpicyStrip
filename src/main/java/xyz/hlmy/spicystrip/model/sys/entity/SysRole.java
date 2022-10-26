package xyz.hlmy.spicystrip.model.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 角色表
 * @TableName sys_role
 */
@TableName(value ="sys_role")
@Data
public class SysRole implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 角色名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 父级ID
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 类型。0：分类；1：角色
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 创建人
     */
    @TableField(value = "create_by")
    private Long createBy;

    /**
     * 修改时间
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

    public Long getId() {
        return id;
    }

    public SysRole setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SysRole setName(String name) {
        this.name = name;
        return this;
    }

    public Long getParentId() {
        return parentId;
    }

    public SysRole setParentId(Long parentId) {
        this.parentId = parentId;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public SysRole setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public SysRole setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public SysRole setCreateBy(Long createBy) {
        this.createBy = createBy;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public SysRole setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public SysRole setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }
}
