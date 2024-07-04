package com.panel.LRapp.Service;

import com.panel.LRapp.Dto.AdminDTO;
import com.panel.LRapp.Dto.feelingsDTO;
import com.panel.LRapp.Entity.AdminChallenge;
import com.panel.LRapp.Entity.feelings;
import com.panel.LRapp.response.*;

import java.util.List;
import java.util.Set;

public interface AdminCService {
    AdminCResponse save(AdminChallenge adminChallenge);
    void delete(int id);
    AdminCResponse update(AdminChallenge adminChallenge);

    CRAdminCU updateCR(String t,AdminDTO adminDTO);

    ACDisplayResponse findById(int id);

    List<AdminChallenge> findByName(String name);

    List<AdminChallenge> findAll();

    void enrollUserInAdmin(int userId, int adminId);

    AllCAUser findAllCAUser(String t);
}
