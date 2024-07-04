package com.panel.LRapp.response;

import com.panel.LRapp.Entity.feelings;

public class feelingsResponse {
    private String message;
    private feelings data;

    public feelingsResponse(String message, feelings data) {
        this.message = message;
        this.data = data;
    }

    public feelingsResponse(){

    }

    public feelings getData() {
        return data;
    }

    public void setData(feelings data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "feelingsResponse{" +
                "message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
