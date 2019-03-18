package com.springboot.mybatis.entity;

import lombok.Data;

@Data
public class SysUser {
    private Long userId;
    private String mobile;
    private String password;
    private String username;
    private String avatar;

    public SysUser(Long userId, String mobile, String password, String username, String avatar) {
        this.userId = userId;
        this.mobile = mobile;
        this.password = password;
        this.username = username;
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "userId=" + userId +
                ", mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }

    public SysUser() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
