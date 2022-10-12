package xyz.hlmy.spicystrip.model.actviti.dto;

import lombok.Data;

@Data
public class ModelDto {
    private String modelName;
    private String modelKey;
    private String description;

    public String getModelName() {
        return modelName;
    }

    public ModelDto setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public String getModelKey() {
        return modelKey;
    }

    public ModelDto setModelKey(String modelKey) {
        this.modelKey = modelKey;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ModelDto setDescription(String description) {
        this.description = description;
        return this;
    }
}
