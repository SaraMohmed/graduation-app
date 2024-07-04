package com.panel.LRapp.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reee")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Reham {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
}
