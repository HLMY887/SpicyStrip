package xyz.hlmy.spicystrip.model.actviti.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @TableName act_leave
 */
@TableName(value ="act_leave")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActLeave implements Serializable {
    private Long id;

    private String leaveName;

    private Double leaveDay;

    private String leaveReason;

    private int status;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public ActLeave setId(Long id) {
        this.id = id;
        return this;
    }

    public String getLeaveName() {
        return leaveName;
    }

    public ActLeave setLeaveName(String leaveName) {
        this.leaveName = leaveName;
        return this;
    }

    public Double getLeaveDay() {
        return leaveDay;
    }

    public ActLeave setLeaveDay(Double leaveDay) {
        this.leaveDay = leaveDay;
        return this;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public ActLeave setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public ActLeave setStatus(int status) {
        this.status = status;
        return this;
    }
}