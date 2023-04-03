package model;

import java.io.Serializable;

public class User implements Serializable {
    private int userId;
    private String userName;
    private String password;
    private boolean status;
    private boolean permission;

    public User(int userId, String userName, String password, boolean status, boolean permission) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.status = status;
        this.permission = permission;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", status=" + status +
                '}';
    }
}
