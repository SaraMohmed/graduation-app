package com.panel.LRapp.response;

import com.panel.LRapp.Entity.AdminChallenge;
import com.panel.LRapp.Entity.UserChallengePublic;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UCPublicResponse {
    private String message;

    private UserChallengePublic data;


}
