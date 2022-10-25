package xyz.hlmy.spicystrip.model.actviti.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 我的待办
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyTodoVO implements Serializable {

    private String id;
    private String name;
    private String originalAssignee;
    private String owner;
    private String assignee;
    private String processInstanceId;
    private String executionId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    private Integer suspensionState;    // 1：激活；2：挂起

    private String processName;
    private String startUser;

    public String getId() {
        return id;
    }

    public MyTodoVO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MyTodoVO setName(String name) {
        this.name = name;
        return this;
    }

    public String getOriginalAssignee() {
        return originalAssignee;
    }

    public MyTodoVO setOriginalAssignee(String originalAssignee) {
        this.originalAssignee = originalAssignee;
        return this;
    }

    public String getOwner() {
        return owner;
    }

    public MyTodoVO setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public String getAssignee() {
        return assignee;
    }

    public MyTodoVO setAssignee(String assignee) {
        this.assignee = assignee;
        return this;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public MyTodoVO setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
        return this;
    }

    public String getExecutionId() {
        return executionId;
    }

    public MyTodoVO setExecutionId(String executionId) {
        this.executionId = executionId;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public MyTodoVO setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Integer getSuspensionState() {
        return suspensionState;
    }

    public MyTodoVO setSuspensionState(Integer suspensionState) {
        this.suspensionState = suspensionState;
        return this;
    }

    public String getProcessName() {
        return processName;
    }

    public MyTodoVO setProcessName(String processName) {
        this.processName = processName;
        return this;
    }

    public String getStartUser() {
        return startUser;
    }

    public MyTodoVO setStartUser(String startUser) {
        this.startUser = startUser;
        return this;
    }
}
