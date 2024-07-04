package com.panel.LRapp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.apache.logging.log4j.util.Strings;

import java.util.List;

@Entity
@Table(name = "userChallengePrivate")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserChallengePrivate {
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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="user5_id")
    private User user;

    public UserChallengePrivate( String name, String description, List<String> days) {

        this.name = name;
        this.description = description;
        this.days = days;
    }
}
