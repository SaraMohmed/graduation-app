package com.panel.LRapp.Service;

import com.panel.LRapp.Dto.feelingsDTO;
import com.panel.LRapp.Entity.feelings;
import com.panel.LRapp.response.feelingsResponse;

import java.util.List;
import java.util.Set;

public interface feelingsService {

   feelingsResponse save(feelings fDTO);
   void delete(int id);
   feelingsResponse update(feelings fDTO);
   feelingsResponse findById(int id);
   List<feelings> findByName(String name);

    void enrollUserInFeel(int userId, int feelId);

    Set<feelings> findAllFUser(String t);

    List<feelings> findAll();

   feelingsResponse saveF(feelings f);
}
