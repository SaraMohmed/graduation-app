package com.panel.LRapp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "adminCDays")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class AdminCDays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "file")
    private String file;

    @Column(name = "content")
    private String content;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="adminC_id")
    private AdminChallenge adminChallenge;

    @Column(name = "rate")
    private double rate;

    @Column(name = "done")
    private boolean isDone;

    public AdminCDays(String name, String file, String content, double rate) {
        this.name = name;
        this.file = file;
        this.content = content;
        this.rate = rate;
    }

    public AdminCDays(String file, String content, AdminChallenge adminChallenge, double rate) {
        this.file = file;
        this.content = content;
        this.adminChallenge = adminChallenge;
        this.rate = rate;
    }

    public AdminCDays(String file, String content, double rate) {
        this.file = file;
        this.content = content;
        this.rate = rate;
    }


}
