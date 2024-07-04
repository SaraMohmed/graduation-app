package com.panel.LRapp.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Mail {
    private String to;
    private int code;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Mail(String to, int code) {
        this.to = to;
        this.code = code;
    }
}
