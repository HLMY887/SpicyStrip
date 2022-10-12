package xyz.hlmy.spicystrip.model.sys.dto;

public class SysUserLoginDto {

    private String nickname;

    private String password;

    public String getNickname() {
        return nickname;
    }

    public SysUserLoginDto setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SysUserLoginDto setPassword(String password) {
        this.password = password;
        return this;
    }
}
