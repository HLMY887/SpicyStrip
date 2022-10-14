package xyz.hlmy.spicystrip.model.actviti.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * @TableName act_form
 */
@TableName(value ="act_form")
public class ActForm implements Serializable {
    private Long id;

    private String code;

    private String name;

    private Integer type;

    private String theme;

    private String designData;

    private String jsCode;

    private String bindTable;

    private String serviceBean;

    private String showColumns;

    private String entityClazz;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDesignData() {
        return designData;
    }

    public void setDesignData(String designData) {
        this.designData = designData;
    }

    public String getJsCode() {
        return jsCode;
    }

    public void setJsCode(String jsCode) {
        this.jsCode = jsCode;
    }

    public String getBindTable() {
        return bindTable;
    }

    public void setBindTable(String bindTable) {
        this.bindTable = bindTable;
    }

    public String getServiceBean() {
        return serviceBean;
    }

    public void setServiceBean(String serviceBean) {
        this.serviceBean = serviceBean;
    }

    public String getShowColumns() {
        return showColumns;
    }

    public void setShowColumns(String showColumns) {
        this.showColumns = showColumns;
    }

    public String getEntityClazz() {
        return entityClazz;
    }

    public void setEntityClazz(String entityClazz) {
        this.entityClazz = entityClazz;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}