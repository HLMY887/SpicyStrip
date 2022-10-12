package xyz.hlmy.spicystrip.model.sys.entity;

public class UserInfo {
    private String username;
    private String nickname;
    private String phone;
    private String avatar;

    public String getUsername() {
        return username;
    }

    public UserInfo setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public UserInfo setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserInfo setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public UserInfo setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }
}
