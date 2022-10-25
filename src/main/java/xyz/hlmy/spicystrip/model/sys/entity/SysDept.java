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
    private Long parent_id;

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
    private Long dept_id;

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
    private LocalDateTime update_time;

    /**
     * 创建人
     */
    @TableField(value = "create_by")
    private Long create_by;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime create_time;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}