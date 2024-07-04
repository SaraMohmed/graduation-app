package com.panel.LRapp.Service;

import com.panel.LRapp.Entity.ContactUs;
import com.panel.LRapp.Repo.ContactUsRepo;
import com.panel.LRapp.response.ContactUsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactUsServiceImpl implements ContactUsService{
    @Autowired
    private ContactUsRepo contactUsRepo;
    @Override
    public ContactUsResponse save(ContactUs contactUs) {
        return new ContactUsResponse("تم الارسال بنجاح :)",contactUsRepo.save(contactUs));
    }

    @Override
    public List<ContactUs> findAll() {
        return contactUsRepo.findAll();
    }

    @Override
    public String delete(int id) {
        Optional<ContactUs> contactUs=contactUsRepo.findById(id);
        if(contactUs.isEmpty()){
            return "لم يتم العثور على هذا العنصر :(";
        }
        contactUsRepo.deleteById(id);
        return "تم الحذف بنجاح :)";
    }
}
