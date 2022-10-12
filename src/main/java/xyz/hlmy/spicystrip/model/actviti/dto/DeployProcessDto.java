package xyz.hlmy.spicystrip.model.actviti.dto;

/**
 * 部署流程DTO
 */
public class DeployProcessDto {

    private String filePath;
    private String fileImage;
    private String processName;

    public String getFilePath() {
        return filePath;
    }

    public DeployProcessDto setFilePath(String filePath) {
        this.filePath = filePath;
        return this;
    }

    public String getFileImage() {
        return fileImage;
    }

    public DeployProcessDto setFileImage(String fileImage) {
        this.fileImage = fileImage;
        return this;
    }

    public String getProcessName() {
        return processName;
    }

    public DeployProcessDto setProcessName(String processName) {
        this.processName = processName;
        return this;
    }
}
