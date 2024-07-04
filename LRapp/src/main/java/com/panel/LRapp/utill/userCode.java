package com.panel.LRapp.utill;

import java.util.UUID;

public class userCode {
    public static String getCode(){
        return UUID.randomUUID().toString();
    }
}
