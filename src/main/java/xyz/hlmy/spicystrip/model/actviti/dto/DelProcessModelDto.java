package xyz.hlmy.spicystrip.model.actviti.dto;

import lombok.Data;


import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 获取流程模型ID
 */
@Data
public class DelProcessModelDto {

    @NotNull
    private String modelId;

    @NotNull
    private List<String> modelIds;

    public String getModelId() {
        return modelId;
    }

    public DelProcessModelDto setModelId(String modelId) {
        this.modelId = modelId;
        return this;
    }

    public List<String> getModelIds() {
        return modelIds;
    }

    public DelProcessModelDto setModelIds(List<String> modelIds) {
        this.modelIds = modelIds;
        return this;
    }
}
