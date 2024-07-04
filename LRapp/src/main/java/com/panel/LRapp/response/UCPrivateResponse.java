package com.panel.LRapp.response;

import com.panel.LRapp.Entity.AdminChallenge;
import com.panel.LRapp.Entity.UserChallengePrivate;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UCPrivateResponse {
    private String message;
    private UserChallengePrivate data;

}
