package xyz.hlmy.spicystrip.model.actviti.dto;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Accessors(chain = true)
public class ProcessQueryDTo implements Serializable {
    private String username;
    private String modelName;
    private String processName;
    private String taskName;
    private String titleName;
    private String key;
    private Integer status;
    private Date createTime;
    private PageInfoDto pageInfoDto;
}
