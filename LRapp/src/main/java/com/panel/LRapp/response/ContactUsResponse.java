package com.panel.LRapp.response;

import com.panel.LRapp.Entity.ContactUs;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ContactUsResponse {
    private String Response;
    private ContactUs data;
}
