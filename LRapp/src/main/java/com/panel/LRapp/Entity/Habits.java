package com.panel.LRapp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "habits")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Habits {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String title;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate startDate;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate endDate;
        @Column(columnDefinition = "varchar(255) default 'false'")
        private boolean done;

        @JsonIgnore
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name ="user2_id")
        private User user;

        public Habits(String title, LocalDate startDate, LocalDate endDate, boolean done) {
            this.title = title;
            this.startDate = startDate;
            this.endDate = endDate;
            this.done = done;
        }
}
