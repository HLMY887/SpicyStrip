package xyz.hlmy.spicystrip.model.actviti.vo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Accessors(chain = true)
public class ProcessModelVO implements Serializable {
    /**
     * 模型ID
     */
    private String id;
    /**
     * 流程模型名称
     */
    private String name;
    /**
     * 流程名称
     */
    private String key;
    /**
     * 流程版本号
     */
    private String version;
    /**
     * 部署ID
     */
    private String deploymentId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 上次更新时间
     */
    private Date lastUpdateTime;
    /**
     *流程名
     */
    private String processName;
    /**
     *流程定义 ID
     */
    private String processDefinitionId;
    /**
     *流程是否被挂起
     */
    private Boolean processSuspended;

}
