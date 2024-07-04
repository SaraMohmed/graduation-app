package com.panel.LRapp.response;

import com.panel.LRapp.Entity.User;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class AuthenticationResponse {
    private  String message;
    private  Boolean status;

    private User data;
    private String accessToken;

    public AuthenticationResponse(String message, Boolean status, User data, String accessToken) {
        this.message = message;
        this.status = status;
        this.data = data;
        this.accessToken = accessToken;
    }
}
