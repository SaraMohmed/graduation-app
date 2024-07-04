package com.panel.LRapp.response;

import com.panel.LRapp.Entity.AdminCDays;
import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class daysAdminResponse {

    private String name;
    private String icon;
    private String description;

    private List<AdminCDays> adminCDays;
}
