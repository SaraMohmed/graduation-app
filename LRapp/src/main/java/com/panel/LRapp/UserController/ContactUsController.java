package com.panel.LRapp.UserController;


import com.panel.LRapp.Entity.ContactUs;
import com.panel.LRapp.Service.ContactUsService;
import com.panel.LRapp.response.ContactUsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/contactUs")
public class ContactUsController {

    @Autowired
    private ContactUsService contactUsService;

    @PostMapping("/create")
    public ContactUsResponse createNewContact(@RequestBody ContactUs contact)  {
        return contactUsService.save(contact);
    }

    @GetMapping("/findAll")
    public List<ContactUs> findAllContact()  {
        return contactUsService.findAll();
    }

    @DeleteMapping("/delete")
    public String deleteContact(@RequestParam("id") int id)  {
        return contactUsService.delete(id);
    }
}
