package xyz.hlmy.spicystrip.model.actviti.dto;

import lombok.Data;

@Data
public class ModelDto {

    /**
     * 唯一标识 KEY
     */
    private String processId;

    /**
     * 流程模型名称
     */
    private String modelName;

    /**
     * 模型描述
     */
    private String description;

    /**
     * 模型分类
     */
    private String category;

    public String getProcessId() {
        return processId;
    }

    public ModelDto setProcessId(String processId) {
        this.processId = processId;
        return this;
    }

    public String getModelName() {
        return modelName;
    }

    public ModelDto setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ModelDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ModelDto setCategory(String category) {
        this.category = category;
        return this;
    }
}
