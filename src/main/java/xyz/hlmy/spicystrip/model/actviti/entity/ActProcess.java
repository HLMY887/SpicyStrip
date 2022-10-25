package xyz.hlmy.spicystrip.model.actviti.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * @TableName act_process
 */
@TableName(value = "act_process")
public class ActProcess implements Serializable {
    private Integer id;

    private String xmlName;

    private String diagramName;


    public Integer getId() {
        return id;
    }

    public ActProcess setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getXmlName() {
        return xmlName;
    }

    public ActProcess setXmlName(String xmlName) {
        this.xmlName = xmlName;
        return this;
    }

    public String getDiagramName() {
        return diagramName;
    }

    public ActProcess setDiagramName(String diagramName) {
        this.diagramName = diagramName;
        return this;
    }
}