package xyz.hlmy.spicystrip.model.sys.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptDto {

    private String dept_name;

    private Long id;

    private String parent_id;

    private Long dept_id;

    private Integer type;

    private int sort;

    private Integer status;

    public String getDept_name() {
        return dept_name;
    }

    public DeptDto setDept_name(String dept_name) {
        this.dept_name = dept_name;
        return this;
    }

    public Long getId() {
        return id;
    }

    public DeptDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getParent_id() {
        return parent_id;
    }

    public DeptDto setParent_id(String parent_id) {
        this.parent_id = parent_id;
        return this;
    }

    public Long getDept_id() {
        return dept_id;
    }

    public DeptDto setDept_id(Long dept_id) {
        this.dept_id = dept_id;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public DeptDto setType(Integer type) {
        this.type = type;
        return this;
    }

    public int getSort() {
        return sort;
    }

    public DeptDto setSort(int sort) {
        this.sort = sort;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public DeptDto setStatus(Integer status) {
        this.status = status;
        return this;
    }
}
