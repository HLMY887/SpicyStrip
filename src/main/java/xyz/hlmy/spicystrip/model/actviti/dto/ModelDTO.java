package xyz.hlmy.spicystrip.model.actviti.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 模型响应数
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModelDTO implements Serializable {

    private String name;

    private String key;

    private String description;

    public String getName() {
        return name;
    }

    public ModelDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getKey() {
        return key;
    }

    public ModelDTO setKey(String key) {
        this.key = key;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ModelDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
