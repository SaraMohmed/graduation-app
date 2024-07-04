package com.panel.LRapp.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class HabitsDTO {


        private int id;
        private String title;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate startDate;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate endDate;
        private boolean done;

        public HabitsDTO(String title, LocalDate startDate, LocalDate endDate, boolean done) {
            this.title = title;
            this.startDate = startDate;
            this.endDate = endDate;
            this.done = done;
        }
}
