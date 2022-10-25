package xyz.hlmy.spicystrip.model.actviti.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @TableName ACT_MODEL
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "ACT_MODEL")
public class ActModel implements Serializable {

    private Long id;

    private String name;

    private String modelKey;

    private Integer version;

    private String description;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public ActModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ActModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getModelKey() {
        return modelKey;
    }

    public ActModel setModelKey(String modelKey) {
        this.modelKey = modelKey;
        return this;
    }

    public Integer getVersion() {
        return version;
    }

    public ActModel setVersion(Integer version) {
        this.version = version;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ActModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "ActModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", modelKey='" + modelKey + '\'' +
                ", version=" + version +
                ", description='" + description + '\'' +
                '}';
    }
}