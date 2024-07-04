package com.panel.LRapp.response;

import com.panel.LRapp.Entity.Posts;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class PostResponse {
    private String message;
    private Posts data;

}
