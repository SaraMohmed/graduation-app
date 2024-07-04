package com.panel.LRapp.response;

import com.panel.LRapp.Entity.Tasks;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class TasksResponse {

        private String message;
        private Tasks data;


}
