package com.panel.LRapp.Service;

import com.panel.LRapp.Entity.ContactUs;
import com.panel.LRapp.response.ContactUsResponse;

import java.util.List;

public interface ContactUsService {
    ContactUsResponse save(ContactUs contactUs);
    List<ContactUs> findAll();
    String delete(int id);
}
