package xyz.hlmy.spicystrip.model.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 用户登录日志
 * @TableName sys_login
 */
@TableName(value ="sys_login")
@Data
public class SysLogin implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id")
    private Integer id;

    /**
     * 用户Id
     */
    @TableField(value = "uid")
    private Long uid;

    /**
     * 用户名
     */
    @TableField(value = "u_name")
    private String uName;

    /**
     * 用户登录Ip
     */
    @TableField(value = "u_ip")
    private String uIp;

    /**
     * 用户登录设备
     */
    @TableField(value = "u_type")
    private String uType;

    /**
     * 用户登录时间
     */
    @TableField(value = "u_time")
    private LocalDateTime uTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public SysLogin setId(Integer id) {
        this.id = id;
        return this;
    }

    public Long getUid() {
        return uid;
    }

    public SysLogin setUid(Long uid) {
        this.uid = uid;
        return this;
    }

    public String getuName() {
        return uName;
    }

    public SysLogin setuName(String uName) {
        this.uName = uName;
        return this;
    }

    public String getuIp() {
        return uIp;
    }

    public SysLogin setuIp(String uIp) {
        this.uIp = uIp;
        return this;
    }

    public String getuType() {
        return uType;
    }

    public SysLogin setuType(String uType) {
        this.uType = uType;
        return this;
    }

    public LocalDateTime getuTime() {
        return uTime;
    }

    public SysLogin setuTime(LocalDateTime uTime) {
        this.uTime = uTime;
        return this;
    }
}
