package com.panel.LRapp.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ACDisplayResponse {
    private String message;
    private String name;
    private String icon;

    private daysAdminResponse data;

    private int rate;
    private boolean isDone;


}
