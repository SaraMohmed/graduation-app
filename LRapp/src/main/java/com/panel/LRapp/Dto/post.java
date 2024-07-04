package com.panel.LRapp.Dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class post {
    private int id;
    private String content;
    private int like;
    private int disLike;

    public post(String content, int like, int disLike) {
        this.content = content;
        this.like = like;
        this.disLike = disLike;
    }
}
