package com.panel.LRapp.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contactUs")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ContactUs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "message")
    private String message;

    public ContactUs(String name, String message) {
        this.name = name;
        this.message = message;
    }
}
