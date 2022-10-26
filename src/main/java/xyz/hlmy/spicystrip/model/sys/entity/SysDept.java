package xyz.hlmy.spicystrip.model.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 部门表
 * @TableName sys_dept
 */
@TableName(value ="sys_dept")
@Data
public class SysDept implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 上级部门ID。一级部门为0
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 部门名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 类型。0：公司；1：部门；2：科室/小组
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 上级部门ID
     */
    @TableField(value = "dept_id")
    private Long deptId;

    /**
     * 排序值。越小越靠前
     */
    @TableField(value = "sort")
    private Integer sort;

    /**
     * 状态。0：正常；1：禁用
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    @TableField(value = "create_by")
    private Long createBy;

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

    public SysDept setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getParentId() {
        return parentId;
    }

    public SysDept setParentId(Long parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getName() {
        return name;
    }

    public SysDept setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public SysDept setType(Integer type) {
        this.type = type;
        return this;
    }

    public Long getDeptId() {
        return deptId;
    }

    public SysDept setDeptId(Long deptId) {
        this.deptId = deptId;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public SysDept setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public SysDept setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public SysDept setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public SysDept setCreateBy(Long createBy) {
        this.createBy = createBy;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public SysDept setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }
}
