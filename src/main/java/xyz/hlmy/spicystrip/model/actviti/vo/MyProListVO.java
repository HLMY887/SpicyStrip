package xyz.hlmy.spicystrip.model.actviti.vo;

import java.io.Serializable;
import java.util.Date;

public class MyProListVO implements Serializable {

    private String id;  // 流程实例ID
    private String name;    // 流程名称
    private String processInstanceId;
    private String processDefinitionId;
    private String businessKey;
    private String startUserId;
    private Date startTime;
    private Date endTime;

    private String theme;   // 表单主题
    private String currentTaskIds;
    private Date submitTime;    // 申请提交时间
    private String currentTaskNames;
    private Integer processStatus; // 流程状态。0:未提交、1:审批中、2:结束（审批通过、拒绝）

    public String getId() {
        return id;
    }

    public MyProListVO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MyProListVO setName(String name) {
        this.name = name;
        return this;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public MyProListVO setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
        return this;
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public MyProListVO setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
        return this;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public MyProListVO setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
        return this;
    }

    public String getStartUserId() {
        return startUserId;
    }

    public MyProListVO setStartUserId(String startUserId) {
        this.startUserId = startUserId;
        return this;
    }

    public Date getStartTime() {
        return startTime;
    }

    public MyProListVO setStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public Date getEndTime() {
        return endTime;
    }

    public MyProListVO setEndTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }

    public String getTheme() {
        return theme;
    }

    public MyProListVO setTheme(String theme) {
        this.theme = theme;
        return this;
    }

    public String getCurrentTaskIds() {
        return currentTaskIds;
    }

    public MyProListVO setCurrentTaskIds(String currentTaskIds) {
        this.currentTaskIds = currentTaskIds;
        return this;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public MyProListVO setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
        return this;
    }

    public String getCurrentTaskNames() {
        return currentTaskNames;
    }

    public MyProListVO setCurrentTaskNames(String currentTaskNames) {
        this.currentTaskNames = currentTaskNames;
        return this;
    }

    public Integer getProcessStatus() {
        return processStatus;
    }

    public MyProListVO setProcessStatus(Integer processStatus) {
        this.processStatus = processStatus;
        return this;
    }

    @Override
    public String toString() {
        return "MyProListVO{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", processInstanceId='" + processInstanceId + '\'' +
                ", processDefinitionId='" + processDefinitionId + '\'' + ", businessKey='" + businessKey + '\''
                + ", startUserId='" + startUserId + '\'' + ", startTime=" + startTime + ", endTime="
                + endTime + ", theme='" + theme + '\'' + ", currentTaskIds='" + currentTaskIds + '\''
                + ", submitTime=" + submitTime + ", currentTaskNames='" + currentTaskNames + '\''
                + ", processStatus=" + processStatus + '}';
    }
}
