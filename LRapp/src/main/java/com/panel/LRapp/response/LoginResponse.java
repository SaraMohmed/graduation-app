package com.panel.LRapp.response;

import com.panel.LRapp.Entity.User;

public class LoginResponse {
    private  String message;
    private  Boolean status;

    private User data;

    public LoginResponse(String message, Boolean status,User data) {
        this.message = message;
        this.status = status;
        this.data=data;
    }

    public LoginResponse(){

    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", data=" + data +
                '}';
    }
}
