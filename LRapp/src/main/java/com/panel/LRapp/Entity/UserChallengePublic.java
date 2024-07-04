package com.panel.LRapp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.apache.logging.log4j.util.Strings;

import java.util.List;

@Entity
@Table(name = "userChallengePublic")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserChallengePublic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "Description")
    private String description;
    @Column(name = "days")
    private List<String> days;
    @Column(name = "username")
    private String username;
    @Column(name = "image")
    private String image;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name ="user6_id")
    private User user;

    public UserChallengePublic(String name, String description, List<String> days) {
        this.name = name;
        this.description = description;
        this.days = days;
    }

    public UserChallengePublic(String name, String description, List<String> days, String username, String image, User user) {
        this.name = name;
        this.description = description;
        this.days = days;
        this.username = username;
        this.image = image;
        this.user = user;
    }
}
