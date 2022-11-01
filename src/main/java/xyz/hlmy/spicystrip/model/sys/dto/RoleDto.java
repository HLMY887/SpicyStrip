package xyz.hlmy.spicystrip.model.sys.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto implements Serializable {

    private Long id;

    private Long parent_id;


    private Integer role_type;

    private String role_remark;

    @NotBlank(message = "角色名称不能为空")
    private String role_name;

    public String getRole_name() {
        return role_name;
    }

    public RoleDto setRole_name(String role_name) {
        this.role_name = role_name;
        return this;
    }


    public String getRole_remark() {
        return role_remark;
    }

    public RoleDto setRole_remark(String role_remark) {
        this.role_remark = role_remark;
        return this;
    }

    public Long getId() {
        return id;
    }

    public RoleDto setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public RoleDto setParent_id(Long parent_id) {
        this.parent_id = parent_id;
        return this;
    }

    public Integer getRole_type() {
        return role_type;
    }

    public RoleDto setRole_type(Integer role_type) {
        this.role_type = role_type;
        return this;
    }
}
