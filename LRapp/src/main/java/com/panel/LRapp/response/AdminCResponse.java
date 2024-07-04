package com.panel.LRapp.response;

import com.panel.LRapp.Entity.AdminChallenge;
import com.panel.LRapp.Entity.feelings;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class AdminCResponse {
    private String message;
    private AdminChallenge data;
}
