package com.panel.LRapp.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AdminDTO {

    private int id;

    private boolean done1;

    private double rate1;

    List<AdminDaysDto> days;
}
