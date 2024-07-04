package com.panel.LRapp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "content")
    private String content;
    @Column(name = "countL")
    private int like;
    @Column(name = "countDL")
    private int disLike;
    @Column(name = "name")
    private String userName;
    @Column(name = "image")
    private String image;
    @Column(columnDefinition = "varchar(255) default 'false'")
    private boolean userLiked;
    @Column(columnDefinition = "varchar(255) default 'false'")
    private boolean userDisLiked;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="user3_id")
    private User user;



    public void setUserDisLiked(boolean userDisLiked) {
        this.userDisLiked = userDisLiked;
    }

    public Posts(String content, int like, int disLike, String userName, String image, boolean userLiked, boolean userDisLiked) {
        this.content = content;
        this.like = like;
        this.disLike = disLike;
        this.userName = userName;
        this.image = image;
        this.userLiked = userLiked;
        this.userDisLiked = userDisLiked;
    }

    public Posts(String content, int like, int disLike, String userName, String image) {
        this.content = content;
        this.like = like;
        this.disLike = disLike;
        this.userName = userName;
        this.image = image;

    }


}
