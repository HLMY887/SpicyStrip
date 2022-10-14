package xyz.hlmy.spicystrip.model.actviti.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


@Data
public class SaveProcessDto {
    private String key;
    private String reason;

    private MultipartFile file;

    public String getReason() {
        return reason;
    }

    public SaveProcessDto setReason(String reason) {
        this.reason = reason;
        return this;
    }

    public MultipartFile getFile() {
        return file;
    }

    public SaveProcessDto setFile(MultipartFile file) {
        this.file = file;
        return this;
    }
}
