package com.panel.LRapp.response;

import com.panel.LRapp.Entity.Habits;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class HabitsResponse {

    private String message;
    private Habits data;

}
