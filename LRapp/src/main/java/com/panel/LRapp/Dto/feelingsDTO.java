package com.panel.LRapp.Dto;

import jakarta.persistence.Column;
import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class feelingsDTO {
    private int id;

    private String name;

    private String description;

    private List<String> advice;

    private List<String> file;




    public feelingsDTO(String name, String description, List<String> advice, List<String> file) {
        this.name = name;
        this.description = description;
        this.advice = advice;
        this.file = file;
    }

}
