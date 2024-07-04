package com.panel.LRapp.response;

import com.panel.LRapp.Entity.Posts;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class PostList {
    private List<Posts> posts;
}
