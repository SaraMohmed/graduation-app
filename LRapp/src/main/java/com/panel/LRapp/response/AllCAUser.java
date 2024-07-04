package com.panel.LRapp.response;

import com.panel.LRapp.Entity.AdminChallenge;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class AllCAUser {
    private List<AdminChallenge> adminChallenges;
    private String name;
    private String image;
}
