package com.panel.LRapp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "feelingDays")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class FeelingDays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "advice")
    private String advice;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="feeling_id")
    private feelings feeling;



    public void setFeeling(feelings feeling) {
        this.feeling = feeling;
    }

    public FeelingDays(String advice) {
        this.advice = advice;
    }
}
