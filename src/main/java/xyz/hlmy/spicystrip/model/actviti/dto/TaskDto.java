package xyz.hlmy.spicystrip.model.actviti.dto;

public class TaskDto {

    private String task;

    private String userName;

    private String comment;




    public String getUserName() {
        return userName;
    }

    public TaskDto setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public TaskDto setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public String getTask() {
        return task;
    }

    public TaskDto setTask(String task) {
        this.task = task;
        return this;
    }
}
