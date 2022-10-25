package xyz.hlmy.spicystrip.model.actviti.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ProcessModelVO {

    private String id;  // 模型ID
    private String name;    // 流程模型名称
    private String key;  //模型唯一标识
    private String version; //版本
    private String deploymentId; //部署ID
    private Date createTime; //模型创建时间
    private Date lastUpdateTime; //上一次更新时间
    private String processName; //流程定义名称
    private String processDefinitionId; //流程定义名称
    private Boolean processSuspended;   // 流程是否被挂起
    private String diagramName;  //流程图


    public String getId() {
        return id;
    }

    public ProcessModelVO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProcessModelVO setName(String name) {
        this.name = name;
        return this;
    }

    public String getKey() {
        return key;
    }

    public ProcessModelVO setKey(String key) {
        this.key = key;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public ProcessModelVO setVersion(String version) {
        this.version = version;
        return this;
    }

    public String getDeploymentId() {
        return deploymentId;
    }

    public ProcessModelVO setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public ProcessModelVO setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public ProcessModelVO setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        return this;
    }

    public String getProcessName() {
        return processName;
    }

    public ProcessModelVO setProcessName(String processName) {
        this.processName = processName;
        return this;
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public ProcessModelVO setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
        return this;
    }

    public Boolean getProcessSuspended() {
        return processSuspended;
    }

    public ProcessModelVO setProcessSuspended(Boolean processSuspended) {
        this.processSuspended = processSuspended;
        return this;
    }


    public String getDiagramName() {
        return diagramName;
    }

    public ProcessModelVO setDiagramName(String diagramName) {
        this.diagramName = diagramName;
        return this;
    }
}
