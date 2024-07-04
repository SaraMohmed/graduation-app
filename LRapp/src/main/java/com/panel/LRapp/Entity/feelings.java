package com.panel.LRapp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "feelings")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class feelings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    @Column(name = "Description")
    private String description;



    @OneToMany(mappedBy = "feeling",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<FeelingDays> feelingDays;


    @JsonIgnore
    @ManyToMany(mappedBy = "feelingsSet")
    private Set<User> user = new HashSet<>();

    public feelings(String name, String description) {
        this.name = name;
        this.description = description;

    }
}
