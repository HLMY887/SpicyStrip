package xyz.hlmy.spicystrip.model.actviti.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MyTodoDTO implements Serializable {
    private String username;
    private String modelName;
    private String processName;
    private String taskName;
    private String titleName;
    private String key;
    private Integer status;
    private Date createTime;

    public String getUsername() {
        return username;
    }

    public MyTodoDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getModelName() {
        return modelName;
    }

    public MyTodoDTO setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public String getProcessName() {
        return processName;
    }

    public MyTodoDTO setProcessName(String processName) {
        this.processName = processName;
        return this;
    }

    public String getTaskName() {
        return taskName;
    }

    public MyTodoDTO setTaskName(String taskName) {
        this.taskName = taskName;
        return this;
    }

    public String getTitleName() {
        return titleName;
    }

    public MyTodoDTO setTitleName(String titleName) {
        this.titleName = titleName;
        return this;
    }

    public String getKey() {
        return key;
    }

    public MyTodoDTO setKey(String key) {
        this.key = key;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public MyTodoDTO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public MyTodoDTO setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }
}
