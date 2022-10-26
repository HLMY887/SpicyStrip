package xyz.hlmy.spicystrip.model.sys.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class DoLoginDto implements Serializable {

    @NotBlank(message = "请输入用户名")
    private String user_name;

    @NotBlank(message = "请输入密码")
    private String password;

    public String getUser_name() {
        return user_name;
    }

    public DoLoginDto setUser_name(String user_name) {
        this.user_name = user_name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public DoLoginDto setPassword(String password) {
        this.password = password;
        return this;
    }


}
